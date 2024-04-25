/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.client.gui;

public class ButtonWidget extends net.minecraft.client.gui.widget.ButtonWidget {
	public ButtonWidget(int id, int x, int y, String message) {
		super(id, x, y, message);
	}
	public ButtonWidget(int id, int x, int y, int width, int height, String message) {
		super(id, x, y, width, height, message);
	}
}
