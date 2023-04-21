package gay.sylv.tinyquest.block

import net.minecraft.block.BlockState
import net.minecraft.block.FlowerBlock
import net.minecraft.block.ShapeContext
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

class VibrantFlowerBlock(settings: Settings) : FlowerBlock(StatusEffects.REGENERATION, 12, settings) {
	@Deprecated("mojang")
	override fun getOutlineShape(state: BlockState?, world: BlockView?, pos: BlockPos?, context: ShapeContext?): VoxelShape {
		return SHAPE
	}
	
	companion object {
		private val SHAPE = createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)
	}
}
