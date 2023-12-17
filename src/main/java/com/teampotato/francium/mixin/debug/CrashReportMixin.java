package com.teampotato.francium.mixin.debug;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrashReport.class)
public abstract class CrashReportMixin {
    @Inject(method = "getExceptionMessage", at = @At("RETURN"), cancellable = true)
    private void catchSetSeed(CallbackInfoReturnable<String> cir) {
        String message = cir.getReturnValue();
        if (message.contains("java.lang.UnsupportedOperationException: null") && message.contains("at java.util.concurrent.ThreadLocalRandom.setSeed")) {
            cir.setReturnValue("This crash is most likely caused by Francium, please bring this crash report with you to report it!\n" + message);
        }
    }
}
