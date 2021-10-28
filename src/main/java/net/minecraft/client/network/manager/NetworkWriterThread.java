package net.minecraft.client.network.manager;


class NetworkWriterThread extends Thread {

    final NetworkManager netManager;

    NetworkWriterThread(NetworkManager networkmanager, String s) {
        super(s);
        netManager = networkmanager;
    }

    public void run() {
        synchronized (NetworkManager.threadSyncObject) {
            NetworkManager.numWriteThreads++;
        }
        try {
            for (; NetworkManager.isRunning(netManager); NetworkManager.sendNetworkPacket(netManager)) {
            }
        } finally {
            synchronized (NetworkManager.threadSyncObject) {
                NetworkManager.numWriteThreads--;
            }
        }
    }
}
