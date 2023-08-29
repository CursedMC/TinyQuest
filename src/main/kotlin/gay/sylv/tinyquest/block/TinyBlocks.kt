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

import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.id
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.client.render.RenderLayer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap

object TinyBlocks : Initializable {
	val RICH_DIRT: Block = Registry.register(Registries.BLOCK, id("rich_dirt"), Block(QuiltBlockSettings.copyOf(Blocks.DIRT)))
	val VIBRANT_GRASS: Block = Registry.register(Registries.BLOCK, id("vibrant_grass"), Block(QuiltBlockSettings.copyOf(Blocks.GRASS_BLOCK)))
	val CORRUPT_GRASS: Block = Registry.register(Registries.BLOCK, id("corrupt_grass"), Block(QuiltBlockSettings.copyOf(Blocks.GRASS_BLOCK)))
	val FROZEN_GRASS: Block = Registry.register(Registries.BLOCK, id("frozen_grass"), Block(QuiltBlockSettings.copyOf(Blocks.GRASS_BLOCK)))
	val SURVIN: Block = Registry.register(
		Registries.BLOCK,
		id("survin"),
		SurvinBlock(QuiltBlockSettings
			.copyOf(Blocks.SEAGRASS)
			.nonOpaque())
	)
	val SURVIN_FULL_ROOT: Block = Registry.register(Registries.BLOCK, id("survin_full_root"), SurvinBlock(QuiltBlockSettings.copyOf(SURVIN)))
	val VIBRANT_FLOWERS: VibrantFlowerBlock = Registry.register(Registries.BLOCK, id("vibrant_flowers"), VibrantFlowerBlock(QuiltBlockSettings.copyOf(Blocks.CORNFLOWER)))
	
	override fun initialize() {
		BlockRenderLayerMap.put(RenderLayer.getCutout(), SURVIN)
		BlockRenderLayerMap.put(RenderLayer.getCutout(), SURVIN_FULL_ROOT)
	}
}
