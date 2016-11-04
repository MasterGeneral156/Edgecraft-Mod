package com.themastergeneral.edgecraft.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.themastergeneral.edgecraft.Main;

public class NormalEntity extends EntityZombie
{
	private int jumpTicks;
	protected ResourceLocation texture;
    public NormalEntity(World worldIn)
    {
        super(worldIn);
        this.setSize(0.5F, 1.8F); 
    }
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.7D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }
    protected void applyEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    @Override
    public void onLivingUpdate()
    {
    	if (this.jumpTicks > 0)
        {
            --this.jumpTicks;
        }

        if (this.newPosRotationIncrements > 0 && !this.canPassengerSteer())
        {
            double d0 = this.posX + (this.interpTargetX - this.posX) / (double)this.newPosRotationIncrements;
            double d1 = this.posY + (this.interpTargetY - this.posY) / (double)this.newPosRotationIncrements;
            double d2 = this.posZ + (this.interpTargetZ - this.posZ) / (double)this.newPosRotationIncrements;
            double d3 = MathHelper.wrapDegrees(this.interpTargetYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.newPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.interpTargetPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else if (!this.isServerWorld())
        {
            this.motionX *= 0.98D;
            this.motionY *= 0.98D;
            this.motionZ *= 0.98D;
        }

        if (Math.abs(this.motionX) < 0.003D)
        {
            this.motionX = 0.0D;
        }

        if (Math.abs(this.motionY) < 0.003D)
        {
            this.motionY = 0.0D;
        }

        if (Math.abs(this.motionZ) < 0.003D)
        {
            this.motionZ = 0.0D;
        }

        this.worldObj.theProfiler.startSection("ai");

        if (this.isMovementBlocked())
        {
            this.isJumping = false;
            this.moveStrafing = 0.0F;
            this.moveForward = 0.0F;
            this.randomYawVelocity = 0.0F;
        }
        else if (this.isServerWorld())
        {
            this.worldObj.theProfiler.startSection("newAi");
            this.updateEntityActionState();
            this.worldObj.theProfiler.endSection();
        }

        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("jump");

        if (this.isJumping)
        {
            if (this.isInWater())
            {
                this.handleJumpWater();
            }
            else if (this.isInLava())
            {
                this.handleJumpLava();
            }
            else if (this.onGround && this.jumpTicks == 0)
            {
                this.jump();
                this.jumpTicks = 10;
            }
        }
        else
        {
            this.jumpTicks = 0;
        }

        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98F;
        this.moveForward *= 0.98F;
        this.randomYawVelocity *= 0.9F;
        this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("push");
        this.collideWithNearbyEntities();
        this.worldObj.theProfiler.endSection();
    	this.worldObj.theProfiler.startSection("looting");

        if (!this.worldObj.isRemote && this.canPickUpLoot() && !this.dead && this.worldObj.getGameRules().getBoolean("mobGriefing"))
        {
            for (EntityItem entityitem : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(1.0D, 0.0D, 1.0D)))
            {
                if (!entityitem.isDead && entityitem.getEntityItem() != null && !entityitem.cannotPickup())
                {
                    this.updateEquipmentIfNeeded(entityitem);
                }
            }
        }
        this.worldObj.theProfiler.endSection();
    	this.updateArmSwingProgress();
        float f = this.getBrightness(1.0F);

        if (f > 0.5F)
        {
            this.entityAge += 2;
        }
    }
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (isEntityInvulnerable(par1DamageSource))
        {
            return false;
        }
        else
        {
            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityTarget)
    {
        float attackDamage = (float)getEntityAttribute(SharedMonsterAttributes
              .ATTACK_DAMAGE).getAttributeValue();
        int knockbackModifier = 0;

        if (entityTarget instanceof EntityLivingBase)
        {
            knockbackModifier  += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean isTargetHurt = entityTarget.attackEntityFrom(DamageSource
              .causeMobDamage(this), attackDamage);

        if (isTargetHurt)
        {
            if (knockbackModifier  > 0)
            {
                entityTarget.addVelocity((double)(-MathHelper.sin(rotationYaw * 
                      (float)Math.PI / 180.0F) * (float)knockbackModifier  * 0.5F), 
                       0.1D, (double)(MathHelper.cos(rotationYaw * 
                      (float)Math.PI / 180.0F) * (float)knockbackModifier  * 0.5F));
                motionX *= 0.6D;
                motionZ *= 0.6D;
            }

            int fireModifier = EnchantmentHelper.getFireAspectModifier(this);

            if (fireModifier > 0)
            {
                entityTarget.setFire(fireModifier * 4);
            }
        }

        return isTargetHurt ;
    }
	@SideOnly(Side.CLIENT)
	public boolean getAlwaysRenderNameTagForRender()
	{
		return true;
	}
    
}
