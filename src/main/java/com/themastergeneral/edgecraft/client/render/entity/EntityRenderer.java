package com.themastergeneral.edgecraft.client.render.entity;

import javax.annotation.Nonnull;

import com.themastergeneral.edgecraft.entity.NormalEntity;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRenderer extends RenderLiving<NormalEntity> {

    private ResourceLocation mobTexture = new ResourceLocation("modtut:textures/entity/weirdzombie.png");

    public static final Factory FACTORY = new Factory();

    public EntityRenderer(RenderManager rendermanagerIn) {
        // We use the vanilla zombie model here and we simply
        // retexture it. Of course you can make your own model
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull NormalEntity entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<NormalEntity> {

        @Override
        public Render<? super NormalEntity> createRenderFor(RenderManager manager) {
            return new EntityRenderer(manager);
        }

    }

}
