package com.themastergeneral.edgecraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.themastergeneral.edgecraft.entity.ModEntity;
import com.themastergeneral.edgecraft.events.Events;
import com.themastergeneral.edgecraft.events.achievements.Achievements;
import com.themastergeneral.edgecraft.items.ModItems;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	ModItems.init();
    	Achievements.init();
    	Achievements.secondinit();
    	ModEntity.init();
    	MinecraftForge.EVENT_BUS.register(new Events());
    	FMLCommonHandler.instance().bus().register(new Events());
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}