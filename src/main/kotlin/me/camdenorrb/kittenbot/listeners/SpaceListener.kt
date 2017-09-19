package me.camdenorrb.kittenbot.listeners

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.struct.NASA_BOT_NAME
import me.camdenorrb.kittenbot.struct.STEM_GUILD_ID
import me.camdenorrb.kittenbot.struct.STEM_SPACE_CHANNEL_ID
import me.camdenorrb.minibus.event.EventWatcher
import me.camdenorrb.minibus.listener.MiniListener
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.util.concurrent.ThreadLocalRandom


private val msgs = arrayOf("SPACE! :3", "OMG, More space?!", "Thankz NASA <3", ":cat:")

class SpaceListener : MiniListener {

	@EventWatcher
	fun onSpace(event: MessageReceivedEvent) {

		if (event.author.name != NASA_BOT_NAME) return

		val channel = event.channel
		if (event.guild.idLong != STEM_GUILD_ID || channel.idLong != STEM_SPACE_CHANNEL_ID) return

		channel.sendText { msgs[ThreadLocalRandom.current().nextInt(msgs.size)] }
	}

}