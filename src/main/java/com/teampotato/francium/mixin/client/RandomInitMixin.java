package com.teampotato.francium.mixin.client;

import com.teampotato.francium.FranciumRandom;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({MusicManager.class, EndermanRenderer.class, GameRenderer.class, EnchantmentScreen.class, WeighedSoundEvents.class, ClientPacketListener.class, Particle.class, ParticleEngine.class})
public abstract class RandomInitMixin {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private Random useThreadLocalRandom() {
        return new FranciumRandom();
    }
}
