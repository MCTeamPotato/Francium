package com.teampotato.francium.mixin.client;

import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Mixin({MusicManager.class, EndermanRenderer.class, GameRenderer.class, EnchantmentScreen.class, WeighedSoundEvents.class, ClientPacketListener.class, Particle.class, ParticleEngine.class, BlockRenderDispatcher.class})
public abstract class RandomInitMixin {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private Random useThreadLocalRandom() {
        return ThreadLocalRandom.current();
    }
}
