package cc.unilock.xpcrops;

import cc.unilock.xpcrops.config.XPCropsConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPCrops implements ModInitializer {
	private static final String MOD_ID = "xpcrops";
	public static final Logger LOGGER = LoggerFactory.getLogger("XPCrops");
	public static final XPCropsConfig CONFIG = XPCropsConfig.createToml(FabricLoader.getInstance().getConfigDir(), MOD_ID, "main", XPCropsConfig.class);

	@Override
	public void onInitialize() {
		// no-op
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
