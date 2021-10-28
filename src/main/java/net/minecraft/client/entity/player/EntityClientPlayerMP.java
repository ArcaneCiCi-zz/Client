package net.minecraft.client.entity.player;


import me.arcanecici.client.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.mob.impl.EntityItem;
import net.minecraft.client.gui.impl.GuiChat;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.network.manager.NetClientHandler;
import net.minecraft.client.network.packet.impl.*;
import net.minecraft.client.session.Session;
import net.minecraft.client.ui.inventory.InventoryPlayer;
import net.minecraft.client.world.World;

public class EntityClientPlayerMP extends EntityPlayerSP {

    private final NetClientHandler field_797_bg;
    private int field_9380_bx;
    private double field_9379_by;
    private double field_9378_bz;
    private double field_9377_bA;
    private double field_9376_bB;
    private float field_9385_bC;
    private float field_9384_bD;
    private InventoryPlayer field_9383_bE;
    private boolean field_9382_bF;
    private boolean field_9381_bG;
    private int field_12242_bI;

    public EntityClientPlayerMP(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler) {
        super(minecraft, world, session, 0);
        field_9380_bx = 0;
        field_9383_bE = new InventoryPlayer(null);
        field_9382_bF = false;
        field_9381_bG = false;
        field_12242_bI = 0;
        field_797_bg = netclienthandler;
    }

    public boolean canAttackEntity(Entity entity, int i) {
        return false;
    }

    public void heal(int i) {
    }

    public void onUpdate() {
        if (!worldObj.blockExists(MathHelper.floor_double(posX), 64, MathHelper.floor_double(posZ))) {
            return;
        } else {
            super.onUpdate();
            func_4056_N();
            return;
        }
    }

    public void func_6420_o() {
    }

    public void func_4056_N() {
        if (field_9380_bx++ == 20) {
            sendInventoryChanged();
            field_9380_bx = 0;
        }
        boolean flag = func_381_o();
        if (flag != field_9381_bG) {
            if (flag) {
                field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 104));
            } else {
                field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 105));
            }
            field_9381_bG = flag;
        }
        double d = posX - field_9379_by;
        double d1 = boundingBox.minY - field_9378_bz;
        double d2 = posY - field_9377_bA;
        double d3 = posZ - field_9376_bB;
        double d4 = rotationYaw - field_9385_bC;
        double d5 = rotationPitch - field_9384_bD;
        boolean flag1 = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
        boolean flag2 = d4 != 0.0D || d5 != 0.0D;
        if (ridingEntity != null) {
            if (flag2) {
                field_797_bg.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, onGround));
            } else {
                field_797_bg.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, onGround));
            }
            flag1 = false;
        } else if (flag1 && flag2) {
            field_797_bg.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else if (flag1) {
            field_797_bg.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, onGround));
            field_12242_bI = 0;
        } else if (flag2) {
            field_797_bg.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else {
            field_797_bg.addToSendQueue(new Packet10Flying(onGround));
            if (field_9382_bF != onGround || field_12242_bI > 20) {
                field_12242_bI = 0;
            } else {
                field_12242_bI++;
            }
        }
        field_9382_bF = onGround;
        if (flag1) {
            field_9379_by = posX;
            field_9378_bz = boundingBox.minY;
            field_9377_bA = posY;
            field_9376_bB = posZ;
        }
        if (flag2) {
            field_9385_bC = rotationYaw;
            field_9384_bD = rotationPitch;
        }
    }

    private void sendInventoryChanged() {
        if (!inventory.compareInventory(field_9383_bE)) {
            field_797_bg.addToSendQueue(new Packet5PlayerInventory(-1, inventory.mainInventory));
            field_797_bg.addToSendQueue(new Packet5PlayerInventory(-2, inventory.craftingInventory));
            field_797_bg.addToSendQueue(new Packet5PlayerInventory(-3, inventory.armorInventory));
            field_9383_bE = inventory.copyInventory();
        }
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem) {
        Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);
        field_797_bg.addToSendQueue(packet21pickupspawn);
        entityitem.posX = (double) packet21pickupspawn.xPosition / 32D;
        entityitem.posY = (double) packet21pickupspawn.yPosition / 32D;
        entityitem.posZ = (double) packet21pickupspawn.zPosition / 32D;
        entityitem.motionX = (double) packet21pickupspawn.rotation / 128D;
        entityitem.motionY = (double) packet21pickupspawn.pitch / 128D;
        entityitem.motionZ = (double) packet21pickupspawn.roll / 128D;
    }

    public void sendChatMessage(String msg) {

        String[] args = msg.split(" ");

        if (args.length > 0 && args[0].startsWith(".")) {
            Client.getInstance().getCommandManager().execute(args);
            return;
        }

        field_797_bg.addToSendQueue(new Packet3Chat(GuiChat.isCommand ? "/" + msg : msg));
        GuiChat.isCommand = false;
    }

    public void func_457_w() {
        super.func_457_w();
        field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 1));
    }

    public void func_9367_r() {
        sendInventoryChanged();
        field_797_bg.addToSendQueue(new Packet9());
    }

    protected void damageEntity(int i) {
        health -= i;
    }
}
