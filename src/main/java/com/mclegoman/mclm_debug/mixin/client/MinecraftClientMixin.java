/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.mixin.client;

import com.mclegoman.mclm_debug.client.Debug;
import com.mclegoman.mclm_debug.common.Data;
import net.minecraft.client.C_5664496;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(C_5664496.class)
public abstract class MinecraftClientMixin {
	@Inject(method = "m_8832598", at = @At(value = "TAIL"))
	private void debug$tick(CallbackInfo ci) {
		Optional<ModContainer> modContainer = QuiltLoader.getModContainer(Data.version.getID());
		modContainer.ifPresent(Debug::onTick);
	}
	@Inject(method = "run", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;<init>(Lnet/minecraft/client/C_5664496;II)V"))
	private void debug$run(CallbackInfo ci) {
		Optional<ModContainer> modContainer = QuiltLoader.getModContainer(Data.version.getID());
		modContainer.ifPresent(Debug::onInitialize);
	}
}