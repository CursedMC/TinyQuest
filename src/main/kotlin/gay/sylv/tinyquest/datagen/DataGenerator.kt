package gay.sylv.tinyquest.datagen

import com.mojang.serialization.Lifecycle
import gay.sylv.tinyquest.Initializable
import gay.sylv.tinyquest.TinyQuestMod
import gay.sylv.tinyquest.id
import net.minecraft.block.MapColor
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.SimpleRegistry
import net.minecraft.resource.ResourceType
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import org.quiltmc.qsl.resource.loader.api.InMemoryResourcePack
import org.quiltmc.qsl.resource.loader.api.ResourceLoader
import org.quiltmc.qsl.resource.loader.api.ResourcePackRegistrationContext

abstract class DataGenerator {
	abstract fun onRegisterPack(context: ResourcePackRegistrationContext)
	
	/**
	 * Generates a specific type of data in a specific directory.
	 */
	abstract class DataMill(private val context: ResourcePackRegistrationContext, private val path: String) {
		abstract fun addToPack(pack: InMemoryResourcePack)
		
		@Suppress("MemberVisibilityCanBePrivate")
		protected fun getResource(path: String, vararg args: Any): String {
			return String.format(getResource(path), *args)
		}
		
		@Suppress("MemberVisibilityCanBePrivate")
		protected fun getResource(path: String): String {
			return context.resourceManager().getResource(datagenPathId(path)).get().open().readAllBytes().decodeToString()
		}
		
		protected fun putResource(path: String, datagenPath: String, vararg args: Any) {
			putResource(path, getResource(datagenPath, args))
		}
		
		@Suppress("MemberVisibilityCanBePrivate")
		protected fun putResource(path: String, content: String) {
			PACK.putResource(ResourceType.CLIENT_RESOURCES, pathId(path), content.encodeToByteArray())
		}
		
		private fun datagenPathId(path: String): Identifier {
			return id("datagen/${this.path}/$path")
		}
		
		private fun pathId(path: String): Identifier {
			return id("${this.path}/$path")
		}
	}
	
	abstract class BlockstateDataMill(context: ResourcePackRegistrationContext) : DataMill(context, "blockstates")
	
	abstract class BlockModelMill(context: ResourcePackRegistrationContext) : DataMill(context, "models/block")
	
	abstract class ItemModelDataMill(context: ResourcePackRegistrationContext) : DataMill(context, "models/item")
	
	@Suppress("unused")
	companion object : Initializable {
		private val REGISTRY_KEY: RegistryKey<Registry<DataGenerator>> = RegistryKey.ofRegistry(id("data_generator"))
		private val REGISTRY: Registry<DataGenerator> = SimpleRegistry(REGISTRY_KEY, Lifecycle.stable(), false)
		internal val PACK: InMemoryResourcePack = InMemoryResourcePack.Named("TinyQuest Resources")
		
		// wood
		val EPPIAN: WoodType = WoodType("eppian", MapColor.WOOD, MapColor.PODZOL, BlockSoundGroup.CHERRY_WOOD, false)
		
		fun <T: DataGenerator> register(path: String, dataGenerator: T): T {
			return Registry.register(REGISTRY, id(path), dataGenerator)
		}
		
		init {
			ResourceLoader.get(ResourceType.CLIENT_RESOURCES).registerDefaultResourcePackEvent.register { context ->
				REGISTRY.forEach {
					TinyQuestMod.LOGGER.info("on register pack :3")
					it.onRegisterPack(context)
				}
				
				context.addResourcePack(PACK)
			}
		}
		
		override fun initialize() {
			/* no-op */
		}
	}
}
