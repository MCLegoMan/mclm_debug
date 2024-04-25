/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.client.gui;

import com.mclegoman.mclm_debug.client.data.ClientData;
import com.mclegoman.mclm_debug.config.DebugConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

public class ConfigScreen extends Screen {
	private final Screen parent;
	public ConfigScreen(Screen screen) {
		this.parent = screen;
	}
	public final void init() {
		this.buttons.add(new ButtonWidget(0, this.width / 2 - 100, this.height / 6, "Show Mod(s): " + DebugConfig.instance.showMods.value()));
		this.buttons.add(new ButtonWidget(1, this.width / 2 - 100, this.height / 6 + 168, "Done"));
	}

	protected void buttonClicked(ButtonWidget button) {
		if (button.active) {
			if (button.id == 0) {
				DebugConfig.instance.showMods.setValue(!DebugConfig.instance.showMods.value());
				button.message = "Show Mod(s): " + DebugConfig.instance.showMods.value();
				DebugConfig.instance.save();
			}
			if (button.id == 1) ClientData.minecraft.m_6408915(this.parent);
		}
	}

	public final void render(int i, int j) {
		fillGradient(0, 0, this.width, this.height, 1610941696, -1607454624);
		drawCenteredString(this.textRenderer, "Debug Config", this.width / 2, 20, 16777215);
		super.render(i, j);
	}
}
