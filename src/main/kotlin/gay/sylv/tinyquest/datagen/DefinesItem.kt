package gay.sylv.tinyquest.datagen

import net.minecraft.item.ItemGroup.ItemStackCollector

/**
 * If this data generator defines new items. This allows automatic registration in item groups.
 */
interface DefinesItem {
	fun addStacksToCollector(collector: ItemStackCollector)
}
