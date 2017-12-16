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

import com.themastergeneral.edgecraft.entity.EJEntity;

public class EJRender extends RenderLiving<EJEntity> {

    private ResourceLocation mobTexture = new ResourceLocation("edgecraft:textures/entity/ej.png");

    public static final Factory FACTORY = new Factory();

    public EJRender(RenderManager rendermanagerIn) 
    {
        super(rendermanagerIn, new ModelPlayer(0.5F, true), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EJEntity entity) 
    {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EJEntity> {

        @Override
        public Render<? super EJEntity> createRenderFor(RenderManager manager) 
        {
            return new EJRender(manager);
        }

    }

}
