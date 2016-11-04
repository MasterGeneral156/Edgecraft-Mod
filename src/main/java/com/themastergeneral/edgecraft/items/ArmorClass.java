package com.themastergeneral.edgecraft.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorClass extends ItemArmor 
{
	public ArmorClass(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) 
	{
        super(material, renderIndex, armorType);
        this.setUnlocalizedName(unlocalizedName);
    }
}