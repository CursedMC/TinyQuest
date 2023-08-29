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
