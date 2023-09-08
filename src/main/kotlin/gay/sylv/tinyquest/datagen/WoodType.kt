package gay.sylv.tinyquest.datagen

import com.mojang.serialization.Lifecycle
import gay.sylv.tinyquest.block.TinyBlocks.registerBlock
import gay.sylv.tinyquest.id
import gay.sylv.tinyquest.item.TinyItems.registerItem
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.block.PillarBlock
import net.minecraft.block.enums.NoteBlockInstrument
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup.ItemStackCollector
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.math.Direction
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings
import org.quiltmc.qsl.resource.loader.api.InMemoryResourcePack
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext

class WoodType(val name: String, woodColor: MapColor, barkColor: MapColor, sounds: BlockSoundGroup, fungus: Boolean) : DataGenerator(), DefinesItem {
	val logName = if (fungus) "stem" else "log"
	val woodName = if (fungus) "hyphae" else "wood"
	val planksName = "planks"
	private val log: Block
	private val logItem: BlockItem
	private val wood: Block
	private val woodItem: BlockItem
	private val strippedLog: Block
	private val strippedLogItem: BlockItem
	private val strippedWood: Block
	private val strippedWoodItem: BlockItem
	private val planks: Block
	private val planksItem: BlockItem
	
	init {
		register("wood_type/$name", this)
		register(this)
		
		val itemSettings = QuiltItemSettings()
		
		log = registerBlock("${name}_$logName", createLogBlock(woodColor, barkColor, sounds))
		logItem = registerItem("${name}_$logName", BlockItem(log, itemSettings))
		
		wood = registerBlock("${name}_$woodName", createLogBlock(barkColor, barkColor, sounds))
		woodItem = registerItem("${name}_$woodName", BlockItem(wood, itemSettings))
		
		strippedLog = registerBlock("stripped_${name}_$logName", createLogBlock(woodColor, woodColor, sounds))
		strippedLogItem = registerItem("stripped_${name}_$logName", BlockItem(strippedLog, itemSettings))
		
		strippedWood = registerBlock("stripped_${name}_$woodName", createLogBlock(woodColor, woodColor, sounds))
		strippedWoodItem = registerItem("stripped_${name}_$woodName", BlockItem(strippedWood, itemSettings))
		
		planks = registerBlock("${name}_$planksName", createLogBlock(woodColor, woodColor, sounds))
		planksItem = registerItem("${name}_$planksName", BlockItem(planks, itemSettings))
	}
	
	private fun createLogBlock(wood: MapColor, bark: MapColor, sounds: BlockSoundGroup): Block {
		return PillarBlock(
			QuiltBlockSettings.create()
				.mapColor { state ->
					return@mapColor if (state.get(PillarBlock.AXIS) == Direction.Axis.Y) {
						wood
					} else {
						bark
					}
				}
				.instrument(NoteBlockInstrument.BASS)
				.strength(2.0F)
				.sounds(sounds)
				.lavaIgnitable()
		)
	}
	
	override fun onRegisterPack(context: ResourcePackRegistrationContext) {
		val blockModelMill = BlockModelMill(context, this)
		blockModelMill.addToPack(PACK)
		val blockstateMill = BlockstateMill(context, this)
		blockstateMill.addToPack(PACK)
	}
	
	override fun addStacksToCollector(collector: ItemStackCollector) {
		collector.addItem(logItem)
		collector.addItem(woodItem)
		collector.addItem(strippedLogItem)
		collector.addItem(strippedWoodItem)
		collector.addItem(planksItem)
	}
	
	class BlockstateMill(context: ResourcePackRegistrationContext, private val woodType: WoodType) : DataGenerator.BlockstateMill(context) {
		override fun addToPack(pack: InMemoryResourcePack) {
			// log
			putResource("${woodType.name}_${woodType.logName}.json", "log.json", "${woodType.name}_${woodType.logName}")
			// wood
			putResource("${woodType.name}_${woodType.woodName}.json", "wood.json", "${woodType.name}_${woodType.woodName}")
			// stripped log
			putResource("stripped_${woodType.name}_${woodType.logName}.json", "log.json", "stripped_${woodType.name}_${woodType.logName}")
			// stripped wood
			putResource("stripped_${woodType.name}_${woodType.woodName}.json", "wood.json", "stripped_${woodType.name}_${woodType.woodName}")
			// planks
			putResource("${woodType.name}_${woodType.planksName}.json", "empty.json", "${woodType.name}_${woodType.planksName}")
		}
	}
	
	class BlockModelMill(context: ResourcePackRegistrationContext, private val woodType: WoodType) : DataGenerator.BlockModelMill(context) {
		override fun addToPack(pack: InMemoryResourcePack) {
			// log
			putResource("${woodType.name}_${woodType.logName}.json", "log.json", woodType.name)
			putResource("${woodType.name}_${woodType.logName}_horizontal.json", "log_horizontal.json", woodType.name)
			// wood
			putResource("${woodType.name}_${woodType.woodName}.json", "wood.json", woodType.name)
			// stripped log
			putResource("stripped_${woodType.name}_${woodType.logName}.json", "log.json", "stripped_${woodType.name}")
			putResource("stripped_${woodType.name}_${woodType.logName}_horizontal.json", "log_horizontal.json", "stripped_${woodType.name}")
			// stripped wood
			putResource("stripped_${woodType.name}_${woodType.woodName}.json", "wood.json", "stripped_${woodType.name}")
			// planks
			putResource("${woodType.name}_${woodType.planksName}.json", "cube_all.json", "${woodType.name}_${woodType.planksName}")
		}
	}
	
	companion object {
		private val REGISTRY_KEY: RegistryKey<Registry<WoodType>> = RegistryKey.ofRegistry(id("wood_type"))
		private val REGISTRY: Registry<WoodType> = SimpleRegistry(REGISTRY_KEY, Lifecycle.stable(), false)
		
		fun addAllStacksToCollector(collector: ItemStackCollector) {
			REGISTRY.forEach { it.addStacksToCollector(collector) }
		}
		
		private fun register(woodType: WoodType) {
			Registry.register(REGISTRY, id(woodType.name), woodType)
		}
	}
}
