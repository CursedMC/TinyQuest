package gay.sylv.tinyquest.block

import net.minecraft.block.BlockState
import net.minecraft.block.PlantBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

/**
 * A plant block that has a different texture for the base block of the plant.
 */
class PlantWithRootBlock(settings: Settings) : PlantBlock(settings) {
	init {
		defaultState = defaultState.with(ROOT, false)
	}
	
	override fun canPlantOnTop(floor: BlockState?, world: BlockView?, pos: BlockPos?): Boolean {
		return super.canPlantOnTop(floor, world, pos) || floor?.isOf(this.asBlock())!!
	}
	
	override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
		if (!ctx?.world?.getBlockState(BlockPos(ctx.hitPos?.x?.toInt()!!, ctx.hitPos?.y?.toInt()!!, ctx.hitPos?.z?.toInt()!!))?.isOf(this)!!) {
			return defaultState.with(ROOT, true)
		} else {
			return defaultState
		}
	}
	
	companion object {
		val ROOT: BooleanProperty = BooleanProperty.of("root")
	}
}
