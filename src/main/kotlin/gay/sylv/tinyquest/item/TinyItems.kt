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
package gay.sylv.tinyquest.item

import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.block.TinyBlocks
import gay.sylv.tinyquest.id
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object TinyItems : Initializable {
	// natural blocks
	val RICH_DIRT: BlockItem = registerItem(
		"rich_dirt",
		BlockItem(
			TinyBlocks.RICH_DIRT,
			QuiltItemSettings()
		)
	)
	val VIBRANT_GRASS: BlockItem = registerItem(
		"vibrant_grass",
		BlockItem(
			TinyBlocks.VIBRANT_GRASS,
			QuiltItemSettings()
		)
	)
	val CORRUPT_GRASS: BlockItem = registerItem(
		"corrupt_grass",
		BlockItem(
			TinyBlocks.CORRUPT_GRASS,
			QuiltItemSettings()
		)
	)
	val FROZEN_GRASS: BlockItem = registerItem(
		"frozen_grass",
		BlockItem(
			TinyBlocks.FROZEN_GRASS,
			QuiltItemSettings()
		)
	)
	val RICH_SAND: BlockItem = registerItem(
		"rich_sand",
		BlockItem(
			TinyBlocks.RICH_SAND,
			QuiltItemSettings()
		)
	)
	val MINERALS: BlockItem = registerItem(
		"minerals",
		BlockItem(
			TinyBlocks.MINERALS,
			QuiltItemSettings()
		)
	)
	
	// vegetals
	val SURVIN: BlockItem = registerItem(
		"survin",
		BlockItem(
			TinyBlocks.SURVIN,
			QuiltItemSettings()
		)
	)
	val SURVIN_FULL_ROOT: BlockItem = registerItem(
		"survin_full_root",
		BlockItem(
			TinyBlocks.SURVIN_FULL_ROOT,
			QuiltItemSettings()
		)
	)
	val VIBRANT_FLOWERS: BlockItem = registerItem(
		"vibrant_flowers",
		BlockItem(
			TinyBlocks.VIBRANT_FLOWERS,
			QuiltItemSettings()
		)
	)
	
	override fun initialize() {
	}
	
	internal fun <I: Item> registerItem(id: String, item: I): I {
		return Registry.register(
			Registries.ITEM,
			id(id),
			item
		)
	}
}
