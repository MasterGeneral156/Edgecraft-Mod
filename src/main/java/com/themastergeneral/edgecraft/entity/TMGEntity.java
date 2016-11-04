package com.themastergeneral.edgecraft.entity;

import com.themastergeneral.edgecraft.Main;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TMGEntity extends NormalEntity 
{
	public static final ResourceLocation LOOT = new ResourceLocation(Main.MODID, "entities/tmg");
	public TMGEntity(World worldIn) 
	{
		super(worldIn);
	}
    @Override
    protected ResourceLocation getLootTable() 
    {
        return LOOT;
    }
}
