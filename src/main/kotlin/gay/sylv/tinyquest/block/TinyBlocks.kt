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
import net.minecraft.block.MapColor
import net.minecraft.client.render.RenderLayer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap

object TinyBlocks : Initializable {
	// natural blocks
	val RICH_DIRT: Block = registerBlock(
		"rich_dirt",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.DIRT)
		)
	)
	val VIBRANT_GRASS: Block = registerBlock(
		"vibrant_grass",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.GRASS_BLOCK)
		)
	)
	val CORRUPT_GRASS: Block = registerBlock(
		"corrupt_grass",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.GRASS_BLOCK)
				.mapColor(MapColor.PURPLE_TERRACOTTA)
		)
	)
	val FROZEN_GRASS: Block = registerBlock(
		"frozen_grass",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.GRASS_BLOCK)
				.mapColor(MapColor.SNOW)
		)
	)
	val RICH_SAND: Block = registerBlock(
		"rich_sand",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.SAND)
		)
	)
	val MINERALS: Block = registerBlock(
		"minerals",
		Block(
			QuiltBlockSettings
				.copyOf(Blocks.STONE)
		)
	)
	
	// vegetals
	val SURVIN: Block = registerBlock(
		"survin",
		SurvinBlock(
			QuiltBlockSettings
				.copyOf(Blocks.SEAGRASS)
				.mapColor(MapColor.LIGHT_BLUE)
				.nonOpaque()
		)
	)
	val SURVIN_FULL_ROOT: Block = registerBlock(
		"survin_full_root",
		SurvinRootBlock(
			QuiltBlockSettings
				.copyOf(SURVIN)
				.mapColor(MapColor.PURPLE)
		)
	)
	val VIBRANT_FLOWERS: VibrantFlowerBlock = registerBlock(
		"vibrant_flowers",
		VibrantFlowerBlock(
			QuiltBlockSettings
				.copyOf(Blocks.CORNFLOWER)
		)
	)
	
	override fun initialize() {
		BlockRenderLayerMap.put(RenderLayer.getCutout(), SURVIN)
		BlockRenderLayerMap.put(RenderLayer.getCutout(), SURVIN_FULL_ROOT)
	}
	
	internal fun <B: Block> registerBlock(id: String, block: B): B {
		return Registry.register(
			Registries.BLOCK,
			id(id),
			block
		)
	}
}
