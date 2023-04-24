package gay.sylv.tinyquest.item.group

import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.id
import gay.sylv.tinyquest.item.TinyItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

object TinyGroups : Initializable {
	val TINY_QUEST: ItemGroup = FabricItemGroup.builder(id("tiny_quest"))
		.icon { return@icon ItemStack(TinyItems.VIBRANT_GRASS) }
		.entries { _, collector ->
			collector.addItem(TinyItems.RICH_DIRT)
			collector.addItem(TinyItems.VIBRANT_GRASS)
			collector.addItem(TinyItems.CORRUPT_GRASS)
			collector.addItem(TinyItems.FROZEN_GRASS)
			collector.addItem(TinyItems.SURVIN)
			collector.addItem(TinyItems.SURVIN_FULL_ROOT)
			collector.addItem(TinyItems.VIBRANT_FLOWERS)
		}
		.build()
	
	override fun initialize() {
	}
}
