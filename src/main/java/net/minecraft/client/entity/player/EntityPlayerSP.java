package net.minecraft.client.entity.player;


import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.mob.impl.EntityPickupFX;
import net.minecraft.client.gui.impl.GuiChest;
import net.minecraft.client.gui.impl.GuiCrafting;
import net.minecraft.client.gui.impl.GuiEditSign;
import net.minecraft.client.gui.impl.GuiFurnace;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.render.impl.MovementInput;
import net.minecraft.client.session.Session;
import net.minecraft.client.world.World;
import net.minecraft.client.world.tile.TileEntityFurnace;
import net.minecraft.client.world.tile.TileEntitySign;

public class EntityPlayerSP extends EntityPlayer {

    private final Minecraft mc;
    public MovementInput movement;
    public int field_9373_b;
    public float field_4134_c;
    public float field_4133_d;
    private boolean field_9374_bx;

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i) {
        super(world);
        field_9373_b = 20;
        field_9374_bx = false;
        mc = minecraft;
        dimension = i;
        if (session != null && session.userName != null && session.userName.length() > 0) {
            skinUrl = "http://icebergcraft.com:6543/api/Minecraft/GetSkinByUsername/?username=" + session.userName;
            System.out.println((new StringBuilder()).append("Loading texture ").append(skinUrl));
        }
        username = session.userName;
    }

    public void func_418_b_() {
        super.func_418_b_();
        field_9342_ah = movement.moveStrafe;
        field_9340_ai = movement.moveForward;
        isJumping = movement.jump;
    }

    public void onLivingUpdate() {
        field_4133_d = field_4134_c;
        if (field_9374_bx) {
            if (field_4134_c == 0.0F) {
                mc.sndManager.func_337_a("portal.trigger", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
            }
            field_4134_c += 0.0125F;
            if (field_4134_c >= 1.0F) {
                field_4134_c = 1.0F;
                field_9373_b = 10;
                mc.sndManager.func_337_a("portal.travel", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
                mc.func_6237_k();
            }
            field_9374_bx = false;
        } else {
            if (field_4134_c > 0.0F) {
                field_4134_c -= 0.05F;
            }
            if (field_4134_c < 0.0F) {
                field_4134_c = 0.0F;
            }
        }
        if (field_9373_b > 0) {
            field_9373_b--;
        }
        movement.movePlayer(this);
        if (movement.sneak && field_9287_aY < 0.2F) {
            field_9287_aY = 0.2F;
        }
        super.onLivingUpdate();
    }

    public void func_458_k() {
        movement.func_798_a();
    }

    public void moveThePlayer(int i, boolean flag) {
        movement.move(i, flag);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Score", score);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        score = nbttagcompound.getInteger("Score");
    }

    public void displayGUIChest(IInventory iinventory) {
        mc.displayGuiScreen(new GuiChest(inventory, iinventory));
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign) {
        mc.displayGuiScreen(new GuiEditSign(tileentitysign));
    }

    public void displayWorkbenchGUI() {
        mc.displayGuiScreen(new GuiCrafting(inventory));
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace) {
        mc.displayGuiScreen(new GuiFurnace(inventory, tileentityfurnace));
    }

    public void func_443_a_(Entity entity, int i) {
        mc.field_6321_h.func_1192_a(new EntityPickupFX(mc.theWorld, entity, this, -0.5F));
    }

    public int getPlayerArmorValue() {
        return inventory.getTotalArmorValue();
    }

    public void func_6415_a_(Entity entity) {
        if (entity.interact(this)) {
            return;
        }
        ItemStack itemstack = getCurrentEquippedItem();
        if (itemstack != null && (entity instanceof EntityLiving)) {
            itemstack.useItemOnEntity((EntityLiving) entity);
            if (itemstack.stackSize <= 0) {
                itemstack.func_1097_a(this);
                destroyCurrentEquippedItem();
            }
        }
    }

    public void sendChatMessage(String s) {

    }

    public void func_6420_o() {
    }

    public boolean func_381_o() {
        return movement.sneak;
    }

    public void func_4039_q() {
        if (field_9373_b > 0) {
            field_9373_b = 10;
            return;
        } else {
            field_9374_bx = true;
            return;
        }
    }

    public void setHealth(int i) {
        int j = health - i;
        if (j <= 0) {
            health = i;
        } else {
            field_9346_af = j;
            field_9335_K = health;
            field_9306_bj = field_9366_o;
            damageEntity(j);
            hurtTime = field_9332_M = 10;
        }
    }

    public void func_9367_r() {
        mc.respawn();
    }
}
