package com.teampotato.francium.mixin.common;

import net.minecraft.world.entity.animal.Squid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(Squid.class)
public abstract class SquidMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Ljava/util/Random;setSeed(J)V"))
    private void fixSquidSpawn(Random instance, long l) {
        //Are we really need this seed for squid spawning? I don't think so.
    }
}