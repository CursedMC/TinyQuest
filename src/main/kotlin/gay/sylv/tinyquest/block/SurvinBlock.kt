package gay.sylv.tinyquest.block

import gay.sylv.tinyquest.block.tags.TinyBlockTags
import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

/**
 * A survin block. This class's purpose is to check if the block below is in the tinyquest/#survin tag.
 */
class SurvinBlock(settings: Settings) : PlantWithRootBlock(settings), DefaultPlaceablePlant {
	override fun canPlantOnTop(floor: BlockState?, world: BlockView?, pos: BlockPos?): Boolean {
		return super<DefaultPlaceablePlant>.canPlantOnTop(floor, world, pos) || floor?.isIn(TinyBlockTags.SURVIN)!!
	}
}
