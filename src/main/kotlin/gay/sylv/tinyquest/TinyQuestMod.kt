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
package gay.sylv.tinyquest

import gay.sylv.tinyquest.block.TinyBlocks
import gay.sylv.tinyquest.block.tags.TinyBlockTags
import gay.sylv.tinyquest.item.TinyItems
import gay.sylv.tinyquest.item.group.TinyGroups
import net.minecraft.util.Identifier
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal fun id(path: String) = Identifier("tinyquest", path)

class TinyQuestMod : ModInitializer {
	override fun onInitialize(mod: ModContainer) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name())
		
		// Tags
		TinyBlockTags.initialize()
		
		// Blocks & Items
		TinyBlocks.initialize()
		TinyItems.initialize()
		TinyGroups.initialize()
	}
	
	companion object {
		// This logger is used to write text to the console and the log file.
		// It is considered best practice to use your mod name as the logger's name.
		// That way, it's clear which mod wrote info, warnings, and errors.
		val LOGGER: Logger = LoggerFactory.getLogger("TinyQuest")
	}
}
