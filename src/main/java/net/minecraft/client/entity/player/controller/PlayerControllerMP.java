package net.minecraft.client.entity.player.controller;


import net.minecraft.client.Minecraft;
import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.player.EntityClientPlayerMP;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.network.manager.NetClientHandler;
import net.minecraft.client.network.packet.impl.Packet14BlockDig;
import net.minecraft.client.network.packet.impl.Packet15Place;
import net.minecraft.client.network.packet.impl.Packet16BlockItemSwitch;
import net.minecraft.client.network.packet.impl.Packet7;
import net.minecraft.client.world.World;

public class PlayerControllerMP extends PlayerController {

    private final NetClientHandler field_9438_k;
    private int field_9445_c;
    private int field_9444_d;
    private int field_9443_e;
    private float field_9442_f;
    private float field_1080_g;
    private float field_9441_h;
    private int field_9440_i;
    private boolean isBroken;
    private int field_1075_l;

    public PlayerControllerMP(Minecraft minecraft, NetClientHandler netclienthandler) {
        super(minecraft);
        field_9445_c = -1;
        field_9444_d = -1;
        field_9443_e = -1;
        field_9442_f = 0.0F;
        field_1080_g = 0.0F;
        field_9441_h = 0.0F;
        field_9440_i = 0;
        isBroken = false;
        field_1075_l = 0;
        field_9438_k = netclienthandler;
    }

    public void flipPlayer(EntityPlayer entityplayer) {
        entityplayer.rotationYaw = -180F;
    }

    public boolean sendBlockRemoved(int i, int j, int k, int l) {
        field_9438_k.addToSendQueue(new Packet14BlockDig(3, i, j, k, l));
        int i1 = mc.theWorld.getBlockId(i, j, k);
        int j1 = mc.theWorld.getBlockMetadata(i, j, k);
        boolean flag = super.sendBlockRemoved(i, j, k, l);
        ItemStack itemstack = mc.thePlayer.getCurrentEquippedItem();
        if (itemstack != null) {
            itemstack.hitBlock(i1, i, j, k);
            if (itemstack.stackSize == 0) {
                itemstack.func_1097_a(mc.thePlayer);
                mc.thePlayer.destroyCurrentEquippedItem();
            }
        }
        return flag;
    }

    public void clickBlock(int i, int j, int k, int l) {
        isBroken = true;
        field_9438_k.addToSendQueue(new Packet14BlockDig(2, 0, 0, 0, 0));
        int i1 = mc.theWorld.getBlockId(i, j, k);
        if (i1 > 0 && field_9442_f == 0.0F) {
            Block.blocksList[i1].onBlockClicked(mc.theWorld, i, j, k, mc.thePlayer);
        }
        if (i1 > 0 && Block.blocksList[i1].getBlockBreakStatus(mc.thePlayer) >= 1.0F) {
            sendBlockRemoved(i, j, k, l);
        }
    }

    public void checkAndSendBrokenBlock() {
        if (!isBroken) {
            return;
        } else {
            isBroken = false;
//            System.out.println("Breaking! Send break packet here!");
            field_9438_k.addToSendQueue(new Packet14BlockDig(2, 0, 0, 0, 0));
            field_9442_f = 0.0F;
            field_9440_i = 0;
            return;
        }
    }

    public void sendBlockRemoving(int i, int j, int k, int l) {
        isBroken = true;
        func_730_e();
        field_9438_k.addToSendQueue(new Packet14BlockDig(1, i, j, k, l));
        if (field_9440_i > 0) {
            field_9440_i--;
            return;
        }
        if (i == field_9445_c && j == field_9444_d && k == field_9443_e) {
            int i1 = mc.theWorld.getBlockId(i, j, k);
            if (i1 == 0) {
                return;
            }
            Block block = Block.blocksList[i1];
            field_9442_f += block.getBlockBreakStatus(mc.thePlayer);
            if (field_9441_h % 4F == 0.0F && block != null) {
                mc.sndManager.func_336_b(block.stepSound.func_1145_d(), (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, (block.stepSound.func_1147_b() + 1.0F) / 8F, block.stepSound.func_1144_c() * 0.5F);
            }
            field_9441_h++;
            if (field_9442_f >= 1.0F) {
                sendBlockRemoved(i, j, k, l);
                field_9442_f = 0.0F;
                field_1080_g = 0.0F;
                field_9441_h = 0.0F;
                field_9440_i = 5;
            }
        } else {
            field_9442_f = 0.0F;
            field_1080_g = 0.0F;
            field_9441_h = 0.0F;
            field_9445_c = i;
            field_9444_d = j;
            field_9443_e = k;
        }
    }

    public void func_6467_a(float f) {
        if (field_9442_f <= 0.0F) {
            mc.ingameGUI.field_6446_b = 0.0F;
            mc.renderGlobal.field_1450_i = 0.0F;
        } else {
            float f1 = field_1080_g + (field_9442_f - field_1080_g) * f;
            mc.ingameGUI.field_6446_b = f1;
            mc.renderGlobal.field_1450_i = f1;
        }
    }

    public float getBlockReachDistance() {
        return 6F;
    }

    public void func_717_a(World world) {
        super.func_717_a(world);
    }

    public void func_6474_c() {
        func_730_e();
        field_1080_g = field_9442_f;
        mc.sndManager.func_4033_c();
    }

    private void func_730_e() {
        ItemStack itemstack = mc.thePlayer.inventory.getCurrentItem();
        int i = 0;
        if (itemstack != null) {
            i = itemstack.itemID;
        }
        if (i != field_1075_l) {
            field_1075_l = i;
            field_9438_k.addToSendQueue(new Packet16BlockItemSwitch(0, field_1075_l));
        }
    }

    public boolean sendPlaceBlock(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l) {
        func_730_e();
        field_9438_k.addToSendQueue(new Packet15Place(itemstack == null ? -1 : itemstack.itemID, i, j, k, l));
        return super.sendPlaceBlock(entityplayer, world, itemstack, i, j, k, l);
    }

    public boolean sendUseItem(EntityPlayer entityplayer, World world, ItemStack itemstack) {
        func_730_e();
        field_9438_k.addToSendQueue(new Packet15Place(itemstack == null ? -1 : itemstack.itemID, -1, -1, -1, 255));
        return super.sendUseItem(entityplayer, world, itemstack);
    }

    public EntityPlayer func_4087_b(World world) {
        return new EntityClientPlayerMP(mc, world, mc.session, field_9438_k);
    }

    public void func_6472_b(EntityPlayer entityplayer, Entity entity) {
        func_730_e();
        field_9438_k.addToSendQueue(new Packet7(entityplayer.entityID, entity.entityID, 1));
        entityplayer.attackTargetEntityWithCurrentItem(entity);
    }

    public void func_6475_a(EntityPlayer entityplayer, Entity entity) {
        func_730_e();
        field_9438_k.addToSendQueue(new Packet7(entityplayer.entityID, entity.entityID, 0));
        entityplayer.func_6415_a_(entity);
    }
}
