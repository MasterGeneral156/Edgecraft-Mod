package com.themastergeneral.edgecraft.entity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.themastergeneral.edgecraft.Main;
import com.themastergeneral.edgecraft.client.render.entity.EJRender;
import com.themastergeneral.edgecraft.client.render.entity.EntityRenderer;
import com.themastergeneral.edgecraft.client.render.entity.FyidRender;
import com.themastergeneral.edgecraft.client.render.entity.TMGRender;

public class ModEntity 
{
	public static EJEntity EJ;
	public static FyidEntity Fyid;
	public static TMGEntity TMG;
	
    public static final void init() 
    {
    	EJ = new EJEntity(null);
    	Fyid = new FyidEntity(null);
    	TMG = new TMGEntity(null);
    	
    	EntityRegistry.registerModEntity(EJEntity.class, "ej_monkey", 0, Main.instance, 48, 3, true, 0x00009900, 0x00FF0000);
    	EntityRegistry.registerModEntity(FyidEntity.class, "fyid", 1, Main.instance, 48, 3, true, 0x00FFFFFF, 0x00CCCCCC);
    	EntityRegistry.registerModEntity(TMGEntity.class, "TMG", 2, Main.instance, 48, 3, true, 0x00157DEF, 0x00FF0000);
    }
    @SideOnly(Side.CLIENT)
    public static void initModels() 
    {
        RenderingRegistry.registerEntityRenderingHandler(EJEntity.class, EJRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(FyidEntity.class, FyidRender.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(TMGEntity.class, TMGRender.FACTORY);
    }
    
}
