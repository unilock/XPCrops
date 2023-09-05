package cc.unilock.xpcrops.registry;

import cc.unilock.xpcrops.XPCrops;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class XPCropsTags {
	public static final TagKey<Block> EXCLUDED_CROPS = TagKey.of(RegistryKeys.BLOCK, XPCrops.id("excluded_crops"));
}
