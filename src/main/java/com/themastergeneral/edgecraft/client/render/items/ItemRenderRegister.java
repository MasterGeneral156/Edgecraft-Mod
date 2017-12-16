package com.themastergeneral.edgecraft.client.render.items;

import com.themastergeneral.edgecraft.Main;
import com.themastergeneral.edgecraft.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {

	public static String modid = Main.MODID;

	public static void registerItemRenderer() {
	    reg(ModItems.banana);
	    reg(ModItems.FyidScarf);
	}

	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
