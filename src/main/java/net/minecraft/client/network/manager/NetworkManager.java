package net.minecraft.client.network.manager;


import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetworkManager {

    public static final Object threadSyncObject = new Object();
    public static int numReadThreads;
    public static int numWriteThreads;
    private final Object sendQueueLock;
    private final SocketAddress networkSocket;
    private final List readPackets;
    private final List dataPackets;
    private final List chunkDataPackets;
    private final NetHandler netHandler;
    private final boolean isServerTerminating;
    private final Thread writeThread;
    private final Thread readThread;
    private Socket field_12258_e;
    private DataInputStream socketInputStream;
    private DataOutputStream socketOutputStream;
    private boolean isRunning;
    private boolean isTerminating;
    private String terminationReason;
    private int timeSinceLastRead;
    private int sendQueueByteLength;
    private int chunkDataSendCounter;
    public NetworkManager(Socket socket, String s, NetHandler nethandler) throws IOException {
        sendQueueLock = new Object();
        isRunning = true;
        readPackets = Collections.synchronizedList(new ArrayList());
        dataPackets = Collections.synchronizedList(new ArrayList());
        chunkDataPackets = Collections.synchronizedList(new ArrayList());
        isServerTerminating = false;
        isTerminating = false;
        terminationReason = "";
        timeSinceLastRead = 0;
        sendQueueByteLength = 0;
        chunkDataSendCounter = 0;
        field_12258_e = socket;
        networkSocket = socket.getRemoteSocketAddress();
        netHandler = nethandler;
        socket.setTrafficClass(24);
        socketInputStream = new DataInputStream(socket.getInputStream());
        socketOutputStream = new DataOutputStream(socket.getOutputStream());
        readThread = new NetworkReaderThread(this, (new StringBuilder()).append(s).append(" read thread").toString());
        writeThread = new NetworkWriterThread(this, (new StringBuilder()).append(s).append(" write thread").toString());
        readThread.start();
        writeThread.start();
    }

    static boolean isRunning(NetworkManager networkmanager) {
        return networkmanager.isRunning;
    }

    static boolean isServerTerminating(NetworkManager networkmanager) {
        return networkmanager.isServerTerminating;
    }

    static void readNetworkPacket(NetworkManager networkmanager) {
        networkmanager.readPacket();
    }

    static void sendNetworkPacket(NetworkManager networkmanager) {
        networkmanager.sendPacket();
    }

    static Thread getReadThread(NetworkManager networkmanager) {
        return networkmanager.readThread;
    }

    static Thread getWriteThread(NetworkManager networkmanager) {
        return networkmanager.writeThread;
    }

    public void addToSendQueue(Packet packet) {
        if (isServerTerminating) {
            return;
        }
        synchronized (sendQueueLock) {
            sendQueueByteLength += packet.getPacketSize() + 1;
            if (packet.isChunkDataPacket) {
                chunkDataPackets.add(packet);
            } else {
                dataPackets.add(packet);
            }
        }
    }

    private void sendPacket() {
        try {
            boolean flag = true;
            if (!dataPackets.isEmpty()) {
                flag = false;
                Packet packet;
                synchronized (sendQueueLock) {
                    packet = (Packet) dataPackets.remove(0);
                    sendQueueByteLength -= packet.getPacketSize() + 1;
                }
                Packet.writePacket(packet, socketOutputStream);
            }
            if ((flag || chunkDataSendCounter-- <= 0) && !chunkDataPackets.isEmpty()) {
                flag = false;
                Packet packet1;
                synchronized (sendQueueLock) {
                    packet1 = (Packet) chunkDataPackets.remove(0);
                    sendQueueByteLength -= packet1.getPacketSize() + 1;
                }
                Packet.writePacket(packet1, socketOutputStream);
                chunkDataSendCounter = 50;
            }
            if (flag) {
                Thread.sleep(10L);
            }
        } catch (InterruptedException interruptedexception) {
        } catch (Exception exception) {
            if (!isTerminating) {
                onNetworkError(exception);
            }
        }
    }

    private void readPacket() {
        try {
            Packet packet = Packet.readPacket(socketInputStream);
            if (packet != null) {
                readPackets.add(packet);
            } else {
                networkShutdown("End of stream");
            }
        } catch (Exception exception) {
            if (!isTerminating) {
                onNetworkError(exception);
            }
        }
    }

    private void onNetworkError(Exception exception) {
        exception.printStackTrace();
        networkShutdown((new StringBuilder()).append("Internal exception: ").append(exception).toString());
    }

    public void networkShutdown(String s) {
        if (!isRunning) {
            return;
        }
        isTerminating = true;
        terminationReason = s;
        (new NetworkMasterThread(this)).start();
        isRunning = false;
        try {
            socketInputStream.close();
            socketInputStream = null;
        } catch (Throwable throwable) {
        }
        try {
            socketOutputStream.close();
            socketOutputStream = null;
        } catch (Throwable throwable1) {
        }
        try {
            field_12258_e.close();
            field_12258_e = null;
        } catch (Throwable throwable2) {
        }
    }

    public void processReadPackets() {
        if (sendQueueByteLength > 0x100000) {
            networkShutdown("Send buffer overflow");
        }
        if (readPackets.isEmpty()) {
            if (timeSinceLastRead++ == 1200) {
                networkShutdown("Timed out");
            }
        } else {
            timeSinceLastRead = 0;
        }
        Packet packet;
        for (int i = 100; !readPackets.isEmpty() && i-- >= 0; packet.processPacket(netHandler)) {
            packet = (Packet) readPackets.remove(0);
        }

        if (isTerminating && readPackets.isEmpty()) {
            netHandler.handleErrorMessage(terminationReason);
        }
    }

}
