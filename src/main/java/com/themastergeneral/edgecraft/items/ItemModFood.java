package com.themastergeneral.edgecraft.items;

import com.themastergeneral.edgecraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood 
{
	public ItemModFood(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite) 
	{
	    super(healAmount, saturationModifier, wolvesFavorite);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(CreativeTabs.FOOD);
	}
}
