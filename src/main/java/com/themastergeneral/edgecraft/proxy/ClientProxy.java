package com.themastergeneral.edgecraft.proxy;

import com.themastergeneral.edgecraft.client.render.items.ItemRenderRegister;
import com.themastergeneral.edgecraft.entity.ModEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntity.initModels();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ItemRenderRegister.registerItemRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
