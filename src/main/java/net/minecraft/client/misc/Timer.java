package net.minecraft.client.misc;


import me.arcanecici.client.Client;

public class Timer {

    public float ticksPerSecond;
    public int elapsedTicks;
    public float renderPartialTicks;
    public float timerSpeed;
    public float elapsedPartialTicks;
    private double lastHRTime;
    private long lastSyncSysClock;
    private long lastSyncHRClock;
    private double timeSyncAdjustment;
    public Timer(float f) {
        timerSpeed = 1.0F;
        elapsedPartialTicks = 0.0F;
        timeSyncAdjustment = 1.0D;
        ticksPerSecond = f;
        lastSyncSysClock = System.currentTimeMillis();
        lastSyncHRClock = System.nanoTime() / 0xf4240L;
    }

    public void updateTimer() {
        long l = System.currentTimeMillis();
        long l1 = l - lastSyncSysClock;
        long l2 = System.nanoTime() / 0xf4240L;
        if (l1 > 1000L) {
            long l3 = l2 - lastSyncHRClock;
            double d1 = (double) l1 / (double) l3;
            timeSyncAdjustment += (d1 - timeSyncAdjustment) * 0.20000000298023224D;
            lastSyncSysClock = l;
            lastSyncHRClock = l2;
        }
        if (l1 < 0L) {
            lastSyncSysClock = l;
            lastSyncHRClock = l2;
        }
        double d = (double) l2 / 1000D;
        double d2 = (d - lastHRTime) * timeSyncAdjustment;
        lastHRTime = d;
        if (d2 < 0.0D) {
            d2 = 0.0D;
        }
        if (d2 > 1.0D) {
            d2 = 1.0D;
        }
        if (Client.getInstance().getModManager().getTimerModule().isEnabled()) {
            elapsedPartialTicks += d2 * (double) timerSpeed * (double) ticksPerSecond * 1.7;
        } else {
            elapsedPartialTicks += d2 * (double) timerSpeed * (double) ticksPerSecond;
        }
        elapsedTicks = (int) elapsedPartialTicks;
        elapsedPartialTicks -= elapsedTicks;
        if (elapsedTicks > 10) {
            elapsedTicks = 10;
        }
        renderPartialTicks = elapsedPartialTicks;
    }
}
