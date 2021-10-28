package net.minecraft.client.network.manager;


class NetworkMasterThread extends Thread {

    final NetworkManager netManager;

    NetworkMasterThread(NetworkManager networkmanager) {
        netManager = networkmanager;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.getReadThread(netManager).isAlive()) {
                try {
                    NetworkManager.getReadThread(netManager).stop();
                } catch (Throwable throwable) {
                }
            }
            if (NetworkManager.getWriteThread(netManager).isAlive()) {
                try {
                    NetworkManager.getWriteThread(netManager).stop();
                } catch (Throwable throwable1) {
                }
            }
        } catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }
    }
}
