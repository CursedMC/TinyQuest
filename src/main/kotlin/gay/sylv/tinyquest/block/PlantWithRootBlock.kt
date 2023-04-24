package gay.sylv.tinyquest.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.PlantBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3i
import net.minecraft.world.BlockView

/**
 * A plant block that has a different texture for the base block of the plant.
 */
open class PlantWithRootBlock(settings: Settings) : PlantBlock(settings) {
	init {
		defaultState = defaultState.with(ROOT, false)
	}
	
	override fun canPlantOnTop(floor: BlockState?, world: BlockView?, pos: BlockPos?): Boolean {
		return super.canPlantOnTop(floor, world, pos) || floor?.isOf(this.asBlock())!!
	}
	
	// -- BlockState --
	
	override fun appendProperties(builder: StateManager.Builder<Block, BlockState>?) {
		builder?.add(ROOT)
	}
	
	override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
		return if (!ctx?.world?.getBlockState(ctx.blockPos.subtract(Vec3i(0, 1, 0)))?.isOf(this.asBlock())!!) {
			defaultState.with(ROOT, true)
		} else {
			defaultState
		}
	}
	
	// -- END BlockState --
	
	companion object {
		val ROOT: BooleanProperty = BooleanProperty.of("root")
	}
}
