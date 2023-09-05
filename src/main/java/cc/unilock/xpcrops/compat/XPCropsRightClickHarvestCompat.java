package cc.unilock.xpcrops.compat;

import cc.unilock.xpcrops.XPCrops;
import cc.unilock.xpcrops.mixin.BlockAccessor;
import cc.unilock.xpcrops.registry.XPCropsTags;
import io.github.jamalam360.rightclickharvest.RightClickHarvestCallbacks;
import net.minecraft.server.network.ServerPlayerEntity;

// TODO: this will probably break if RightClickHarvest starts doing things right
//       (i.e. actually breaking the block)
public class XPCropsRightClickHarvestCompat {
	public static void init() {
		RightClickHarvestCallbacks.AFTER_HARVEST.register((player, block) -> {
			if (player instanceof ServerPlayerEntity spe && !block.getDefaultState().isIn(XPCropsTags.EXCLUDED_CROPS)) {
				if (spe.getWorld().getRandom().nextInt(XPCrops.CONFIG.chance.value() - 1) == 0) {
					// we have to use spe blockpos, since rightclickharvest doesn't pass it
					((BlockAccessor) block).callDropExperience(spe.getWorld(), spe.getBlockPos(), spe.getWorld().getRandom().rangeClosed(XPCrops.CONFIG.min_xp.value(), XPCrops.CONFIG.max_xp.value()));
				}
			}
		});
	}
}
