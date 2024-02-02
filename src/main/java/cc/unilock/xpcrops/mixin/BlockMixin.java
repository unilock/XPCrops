package cc.unilock.xpcrops.mixin;

import cc.unilock.xpcrops.XPCrops;
import cc.unilock.xpcrops.registry.XPCropsTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Block.class)
public abstract class BlockMixin {
	@Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"))
	private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
		if (state.getBlock() instanceof CropBlock crop && entity instanceof ServerPlayerEntity player) {
			if (!player.isCreative() && crop.isMature(state) && !state.isIn(XPCropsTags.EXCLUDED_CROPS)) {
				if (world.getRandom().nextInt(XPCrops.CONFIG.chance.value() - 1) == 0) {
					((BlockAccessor) crop).callDropExperience(world, pos, world.getRandom().nextBetween(XPCrops.CONFIG.min_xp.value(), XPCrops.CONFIG.max_xp.value()));
				}
			}
		}
	}
}
