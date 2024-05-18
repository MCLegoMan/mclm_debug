/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.client.util;

import com.mclegoman.mclm_debug.client.data.ClientData;
import com.mclegoman.mclm_debug.config.DebugConfig;
import net.minecraft.client.entity.living.player.InputPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.input.Keyboard;

public class Debug {
	public static String getCoords(InputPlayerEntity player) {
		float x = player.x;
		float y = player.y;
		float z = player.z;
		if (!DebugConfig.instance.showFullCoords.value()) {
			x = Float.parseFloat(String.format("%.1f", x));
			y = Float.parseFloat(String.format("%.1f", y));
			z = Float.parseFloat(String.format("%.1f", z));
		}
		return "x:" + x + " y:" + y + " z:" + z;
	}
	private static boolean showFpsLock;
	public static boolean isDebug;
	public static Screen currentScreen;
	public static void setDebug() {
		if (currentScreen == null) {
			boolean isDebugDown = Keyboard.isKeyDown(Keyboard.KEY_F3);
			if (!showFpsLock && isDebugDown) {
				showFpsLock = true;
				ClientData.minecraft.f_9967940.f_5294533 = !ClientData.minecraft.f_9967940.f_5294533;
			}
			if (showFpsLock && !isDebugDown) showFpsLock = false;
		}
		isDebug = ClientData.minecraft.f_9967940.f_5294533;
	}
}
