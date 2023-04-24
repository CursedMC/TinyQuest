package gay.sylv.tinyquest.block

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.registry.tag.BlockTags
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

/**
 * Describes the default conditions for the `canPlantOnTop` method.
 */
interface DefaultPlaceablePlant {
	fun canPlantOnTop(floor: BlockState?, world: BlockView?, pos: BlockPos?): Boolean {
		return floor!!.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND)
	}
}
