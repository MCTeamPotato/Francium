package com.teampotato.francium.mixin.common;

import com.teampotato.francium.FranciumRandom;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Entity.class, Level.class, MinecraftServer.class, Block.class, WanderingTraderSpawner.class, Raid.class, Explosion.class})
public abstract class RandomInitMixin {
    @Redirect(method = "<init>*", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private Random useThreadLocalRandom() {
        return new FranciumRandom();
    }
}
