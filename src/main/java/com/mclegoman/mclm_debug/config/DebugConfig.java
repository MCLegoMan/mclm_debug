/*
    mclm_debug
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/mclm_debug
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_debug.config;

import com.mclegoman.mclm_debug.common.Data;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.annotations.Comment;
import org.quiltmc.config.api.values.TrackedValue;
import org.quiltmc.loader.api.config.v2.QuiltConfig;

public class DebugConfig extends ReflectiveConfig {
	public static final DebugConfig instance = QuiltConfig.create(Data.version.getID(), Data.version.getID(), DebugConfig.class);
	@Comment("When set to true, the debug overlay will also show loaded mods.")
	public final TrackedValue<Boolean> showMods = this.value(false);
}
