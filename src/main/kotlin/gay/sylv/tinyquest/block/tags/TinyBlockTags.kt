package gay.sylv.tinyquest.block.tags

import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.id
import net.minecraft.block.Block
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey

object TinyBlockTags : Initializable {
	val SURVIN: TagKey<Block> = create("survin")
	
	private fun create(id: String): TagKey<Block> {
		return TagKey.of(RegistryKeys.BLOCK, id(id))
	}
	
	/* no-op */
	override fun initialize() {
	}
}
