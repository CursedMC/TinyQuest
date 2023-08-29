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
