package com.teampotato.francium.mixin.common;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;createInsecureUUID(Ljava/util/Random;)Ljava/util/UUID;"))
    private Random useAnotherRandomToPreventFromUuidDuplicationSpam(Random random) {
        return new Random(ThreadLocalRandom.current().nextLong());
    }
}
