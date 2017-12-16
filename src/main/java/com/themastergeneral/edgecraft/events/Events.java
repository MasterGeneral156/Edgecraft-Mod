package com.themastergeneral.edgecraft.events;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

import com.themastergeneral.edgecraft.events.achievements.Achievements;
import com.themastergeneral.edgecraft.items.ModItems;

public class Events 
{
	@SubscribeEvent
	 public void pickup(ItemPickupEvent event)
	 {
		if(event.pickedUp.getEntityItem().getItem() == ModItems.banana)
		{
			event.player.addStat(Achievements.ej, 1);
		}
	 }
}
