package com.teampotato.francium.mixin.client;

import com.teampotato.francium.FranciumRandom;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.resources.SplashManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({FontSet.class, SpellParticle.class, SplashManager.class})
public abstract class RandomClinitMixin {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private static Random useThreadLocalRandom() {
        return new FranciumRandom();
    }
}
