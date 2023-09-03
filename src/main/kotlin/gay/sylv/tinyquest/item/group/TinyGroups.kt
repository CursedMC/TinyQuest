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
package gay.sylv.tinyquest.item.group

import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.MOD_ID
import gay.sylv.tinyquest.id
import gay.sylv.tinyquest.item.TinyItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

object TinyGroups : Initializable {
	val TINYQUEST: ItemGroup = FabricItemGroup.builder()
		.name(Text.translatable("itemGroup.$MOD_ID.tinyquest"))
		.icon { return@icon ItemStack(TinyItems.VIBRANT_GRASS) }
		.entries { _, collector ->
			collector.addItem(TinyItems.RICH_DIRT)
			collector.addItem(TinyItems.VIBRANT_GRASS)
			collector.addItem(TinyItems.CORRUPT_GRASS)
			collector.addItem(TinyItems.FROZEN_GRASS)
			collector.addItem(TinyItems.RICH_SAND)
			collector.addItem(TinyItems.MINERALS)
			
			collector.addItem(TinyItems.SURVIN)
			collector.addItem(TinyItems.SURVIN_FULL_ROOT)
			collector.addItem(TinyItems.VIBRANT_FLOWERS)
		}
		.build()
	
	override fun initialize() {
		Registry.register(Registries.ITEM_GROUP, id("tinyquest"), TINYQUEST)
	}
}
