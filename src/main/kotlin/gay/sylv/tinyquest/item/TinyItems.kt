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
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object TinyItems : Initializable {
	// Blocks
	val RICH_DIRT: BlockItem = Registry.register(Registries.ITEM, id("rich_dirt"), BlockItem(TinyBlocks.RICH_DIRT, QuiltItemSettings()))
	val VIBRANT_GRASS: BlockItem = Registry.register(Registries.ITEM, id("vibrant_grass"), BlockItem(TinyBlocks.VIBRANT_GRASS, QuiltItemSettings()))
	val CORRUPT_GRASS: BlockItem = Registry.register(Registries.ITEM, id("corrupt_grass"), BlockItem(TinyBlocks.CORRUPT_GRASS, QuiltItemSettings()))
	val FROZEN_GRASS: BlockItem = Registry.register(Registries.ITEM, id("frozen_grass"), BlockItem(TinyBlocks.FROZEN_GRASS, QuiltItemSettings()))
	val SURVIN: BlockItem = Registry.register(Registries.ITEM, id("survin"), BlockItem(TinyBlocks.SURVIN, QuiltItemSettings()))
	val SURVIN_FULL_ROOT: BlockItem = Registry.register(Registries.ITEM, id("survin_full_root"), BlockItem(TinyBlocks.SURVIN_FULL_ROOT, QuiltItemSettings()))
	val VIBRANT_FLOWERS: BlockItem = Registry.register(Registries.ITEM, id("vibrant_flowers"), BlockItem(TinyBlocks.VIBRANT_FLOWERS, QuiltItemSettings()))
	
	override fun initialize() {
	}
}
