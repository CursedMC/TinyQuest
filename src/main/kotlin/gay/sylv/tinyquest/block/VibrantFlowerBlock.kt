/**
 * TinyQuest  Copyright (C) 2023  CursedMC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
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
		private val SHAPE = createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0)
	}
}
