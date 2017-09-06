package me.camdenorrb.kittenbot.eventmanager

import me.camdenorrb.kittenbot.struct.minibus
import me.camdenorrb.minibus.listener.MiniListener
import net.dv8tion.jda.core.events.Event
import net.dv8tion.jda.core.hooks.IEventManager

class MiniEventManager : IEventManager {

	override fun handle(event: Event) { minibus(event.responseNumber) }


	override fun getRegisteredListeners() = minibus.listenerMap.toList()


	override fun register(listener: Any) = minibus.register(listener as MiniListener)

	override fun unregister(listener: Any?) = minibus.unregister(listener as MiniListener)

}