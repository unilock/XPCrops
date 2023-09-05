package cc.unilock.xpcrops.mixin;

import cc.unilock.xpcrops.XPCrops;
import cc.unilock.xpcrops.registry.XPCropsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin extends Block {
	@Shadow public abstract boolean isMature(BlockState state);

	public CropBlockMixin(Settings settings) {
		super(settings);
	}

	@Override
	public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.afterBreak(world, player, pos, state, blockEntity, stack);
		if (!world.isClient() && !player.isCreative() && this.isMature(state) && !state.isIn(XPCropsTags.EXCLUDED_CROPS)) {
			if (world.getRandom().nextInt(XPCrops.CONFIG.chance.value() - 1) == 0) {
				this.dropExperience((ServerWorld) world, pos, world.getRandom().rangeClosed(XPCrops.CONFIG.min_xp.value(), XPCrops.CONFIG.max_xp.value()));
			}
		}
	}
}
