package com.themastergeneral.edgecraft.items;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public final class ModItems 
{
	public static ArmorMaterial FYID = EnumHelper.addArmorMaterial("fyidclothing", "edgecraft:fyidarmor", 127, new int[] {3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0F);
	public static ItemModFood banana;
	public static ArmorClass FyidScarf;
	
    public static final void init() 
    {
    	banana = new ItemModFood("banana", 4, 0.3F, false);
    	GameRegistry.registerItem(FyidScarf = new ArmorClass("fyid_scarf", FYID, 2, EntityEquipmentSlot.HEAD), "fyid_scarf");
    	
    	GameRegistry.registerItem(banana, "banana");
    }

}