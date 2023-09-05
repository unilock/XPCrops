package cc.unilock.xpcrops.registry;

import cc.unilock.xpcrops.XPCrops;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class XPCropsTags {
	public static final TagKey<Block> EXCLUDED_CROPS = TagKey.of(Registry.BLOCK_KEY, XPCrops.id("excluded_crops"));
}
