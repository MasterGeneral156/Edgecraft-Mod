package com.themastergeneral.edgecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Items extends Item 
{
	protected Items(String unlocalizedName)
	{
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(CreativeTabs.MISC);
	}
}
