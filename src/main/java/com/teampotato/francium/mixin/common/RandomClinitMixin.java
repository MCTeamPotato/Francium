package com.teampotato.francium.mixin.common;

import com.teampotato.francium.FranciumRandom;
import net.minecraft.server.network.ServerLoginPacketListenerImpl;
import net.minecraft.util.Mth;
import net.minecraft.util.datafix.fixes.EntityZombieVillagerTypeFix;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.entity.EnchantmentTableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin({Item.class, Sensor.class, Containers.class, ServerLoginPacketListenerImpl.class, DispenserBlockEntity.class, EnchantmentTableBlockEntity.class, EntityZombieVillagerTypeFix.class, Mth.class})
public abstract class RandomClinitMixin {
    @Redirect(method = "<clinit>", at = @At(value = "NEW", target = "()Ljava/util/Random;", remap = false))
    private static Random useThreadLocalRandom() {
        return new FranciumRandom();
    }
}
