package com.themastergeneral.edgecraft.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

import com.themastergeneral.edgecraft.entity.FyidEntity;

public class FyidRender extends RenderLiving<FyidEntity> {

    private ResourceLocation mobTexture = new ResourceLocation("edgecraft:textures/entity/fyid.png");

    public static final Factory FACTORY = new Factory();

    public FyidRender(RenderManager rendermanagerIn) 
    {
    	super(rendermanagerIn, new ModelPlayer(0.5F, true), 0.5F);
    }
    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull FyidEntity entity) 
    {
        return mobTexture;
    }
    public static class Factory implements IRenderFactory<FyidEntity> {

        @Override
        public Render<? super FyidEntity> createRenderFor(RenderManager manager) 
        {
            return new FyidRender(manager);
        }
    }
}
