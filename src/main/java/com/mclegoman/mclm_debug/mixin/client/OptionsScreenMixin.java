/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.mixin.client;

import com.mclegoman.mclm_debug.client.data.ClientData;
import com.mclegoman.mclm_debug.client.gui.ButtonWidget;
import com.mclegoman.mclm_debug.client.gui.ConfigScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.OptionsScreen;
import org.quiltmc.loader.api.QuiltLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin extends Screen {
	@Shadow private Screen parent;
	@Inject(method = "init", at = @At(value = "TAIL"))
	private void debug$init(CallbackInfo ci) {
		boolean isSaveLoaded = QuiltLoader.isModLoaded("mclm_save");
		this.buttons.add(new ButtonWidget(1000, isSaveLoaded ?  this.width / 2 + 2 : this.width / 2 - 100, this.height / 6 + 110, isSaveLoaded ? 98 : 200, 20, "Debug Config"));
	}
	@Inject(method = "buttonClicked", at = @At(value = "TAIL"))
	private void debug$buttonClicked(net.minecraft.client.gui.widget.ButtonWidget button, CallbackInfo ci) {
		if (button.active) {
			if (button.id == 1000) {
				ClientData.minecraft.m_6408915(new ConfigScreen(new OptionsScreen(this.parent, ClientData.minecraft.f_9967940)));
			}
		}
	}
}
