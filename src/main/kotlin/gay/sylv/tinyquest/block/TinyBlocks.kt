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
		PlantWithRootBlock(QuiltBlockSettings
			.copyOf(Blocks.SEAGRASS)
			.nonOpaque())
	)
	val VIBRANT_FLOWERS: VibrantFlowerBlock = Registry.register(Registries.BLOCK, id("vibrant_flowers"), VibrantFlowerBlock(QuiltBlockSettings.copyOf(Blocks.CORNFLOWER)))
	
	override fun initialize() {
		BlockRenderLayerMap.put(RenderLayer.getCutout(), SURVIN)
	}
}
