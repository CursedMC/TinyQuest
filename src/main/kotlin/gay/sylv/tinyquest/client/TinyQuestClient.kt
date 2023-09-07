package gay.sylv.tinyquest.client

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TinyQuestClient : ClientModInitializer {
	override fun onInitializeClient(mod: ModContainer) {
		LOGGER.info("{} client initialized.", mod.metadata().name())
	}
	
	companion object {
		val LOGGER: Logger = LoggerFactory.getLogger("TinyQuest/Client")
	}
}
