/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.client;

import com.mclegoman.mclm_debug.client.data.ClientData;
import org.quiltmc.loader.api.ModContainer;

public class Debug {
	public static void onInitialize(ModContainer mod) {
	}
	public static void onTick(ModContainer mod) {
		com.mclegoman.mclm_debug.client.util.Debug.currentScreen = ClientData.minecraft.f_0723335;
		com.mclegoman.mclm_debug.client.util.Debug.setDebug();
	}
}