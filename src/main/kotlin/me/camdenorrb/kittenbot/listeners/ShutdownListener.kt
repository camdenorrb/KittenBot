package me.camdenorrb.kittenbot.listeners

import me.camdenorrb.kittenbot.cache.Cmds
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.events.KatBotShutdownEvent
import me.camdenorrb.kittenbot.struct.minibus
import me.camdenorrb.minibus.event.EventWatcher
import me.camdenorrb.minibus.listener.MiniListener

class ShutdownListener : MiniListener {

	@EventWatcher
	fun onShutdown(event: KatBotShutdownEvent) {
		Cmds.cleanup()
		minibus.cleanUp()
		GuildSettings.save()
		println("Wow, how dare you shut me down you incompetent huemin")
	}

}