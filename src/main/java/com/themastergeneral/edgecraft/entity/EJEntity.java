package com.themastergeneral.edgecraft.entity;

import com.themastergeneral.edgecraft.Main;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EJEntity extends NormalEntity 
{
	public static final ResourceLocation LOOT = new ResourceLocation(Main.MODID, "entities/ej");
	public EJEntity(World worldIn) 
	{
		super(worldIn);
	}
    @Override
    protected ResourceLocation getLootTable() 
    {
        return LOOT;
    }
}
