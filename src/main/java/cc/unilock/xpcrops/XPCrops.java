package cc.unilock.xpcrops;

import cc.unilock.xpcrops.compat.XPCropsRightClickHarvestCompat;
import cc.unilock.xpcrops.config.XPCropsConfig;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.loader.api.config.v2.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPCrops implements ModInitializer {
	private static final String MOD_ID = "xpcrops";
	public static final Logger LOGGER = LoggerFactory.getLogger("XPCrops");
	public static final XPCropsConfig CONFIG = QuiltConfig.create(MOD_ID, "main", XPCropsConfig.class);

	@Override
	public void onInitialize(ModContainer mod) {
		if (QuiltLoader.isModLoaded("rightclickharvest")) {
			XPCropsRightClickHarvestCompat.init();
		}
		//LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
