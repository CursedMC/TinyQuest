package gay.sylv.tinyquest.block

import net.minecraft.block.BlockState
import net.minecraft.block.PlantBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

/**
 * A survin root block. This class's purpose is to check if the block below is in a survin root.
 */
@Suppress("DeprecatedCallableAddReplaceWith")
class SurvinRootBlock(settings: Settings) : PlantBlock(settings) {
	override fun canPlantOnTop(floor: BlockState, world: BlockView, pos: BlockPos): Boolean {
		return (super.canPlantOnTop(floor, world, pos) || floor.isOf(TinyBlocks.SURVIN_FULL_ROOT)) && !floor.isOf(TinyBlocks.SURVIN)
	}
	
	@Deprecated("Deprecated in Java")
	override fun canReplace(state: BlockState, context: ItemPlacementContext): Boolean {
		return false
	}
}
