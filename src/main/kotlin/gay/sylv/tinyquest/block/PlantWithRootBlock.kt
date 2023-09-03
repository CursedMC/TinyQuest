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

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.PlantBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.Vec3i

/**
 * A plant block that has a different texture for the base block of the plant.
 */
open class PlantWithRootBlock(settings: Settings) : PlantBlock(settings) {
	init {
		defaultState = defaultState.with(ROOT, false)
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
