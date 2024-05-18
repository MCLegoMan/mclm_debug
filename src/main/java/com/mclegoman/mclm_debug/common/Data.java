/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.common;

import com.mclegoman.releasetypeutils.common.version.Helper;
import com.mclegoman.releasetypeutils.common.version.Version;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;

public class Data {
	public static Version version = new Version("Debug", "mclm_debug", 1, 1, 0, Helper.ReleaseType.RELEASE, 1);
	public static void exit(int status) {
		version.sendToLog(Helper.LogType.INFO, "Halting with status code: " + status + "!");
		if (Mouse.isCreated()) Mouse.destroy();
		if (Keyboard.isCreated()) Keyboard.destroy();
		if (AL.isCreated()) AL.destroy();
		Thread.currentThread().interrupt();
		Runtime.getRuntime().halt(status);
	}
}
