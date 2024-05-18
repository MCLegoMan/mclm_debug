/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.mixin.client;

import com.mclegoman.mclm_debug.client.data.ClientData;
import com.mclegoman.mclm_debug.client.util.Debug;
import com.mclegoman.mclm_debug.config.DebugConfig;
import net.minecraft.client.gui.GameGui;
import net.minecraft.client.render.TextRenderer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameGui.class)
public abstract class GameGuiMixin {
	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TextRenderer;drawWithShadow(Ljava/lang/String;III)V", ordinal = 2))
	private void debug$debug(CallbackInfo ci) {
		TextRenderer textRenderer = ClientData.minecraft.f_0426313;
		if (Debug.isDebug) {
			int y = 23;
			textRenderer.drawWithShadow(Debug.getCoords(ClientData.minecraft.f_6058446), 2, y, 16777215);
			// If the mod is in debug mode, we also show the mod list.
			if (DebugConfig.instance.showMods.value()) {
				y += 11;
				textRenderer.drawWithShadow("Installed Mod(s):", 2, y, 16777215);
				for (ModContainer mod : QuiltLoader.getAllMods()) {
					y += 11;
					textRenderer.drawWithShadow(mod.metadata().name() + " " + mod.metadata().version() + " (" + mod .metadata().id() + ")", 2, y, 16777215);
				}
			}
		}
	}
}
