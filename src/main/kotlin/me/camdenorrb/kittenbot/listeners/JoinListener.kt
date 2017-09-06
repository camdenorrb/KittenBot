package me.camdenorrb.kittenbot.listeners

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.bot
import me.camdenorrb.kittenbot.struct.MIDNIGHT_ID
import me.camdenorrb.minibus.event.EventWatcher
import me.camdenorrb.minibus.listener.MiniListener
import net.dv8tion.jda.core.events.guild.GuildJoinEvent

class JoinListener : MiniListener {

	@EventWatcher
	fun onGuildJoin(event: GuildJoinEvent) {
		val guild = event.guild
		val channel = bot.getUserById(MIDNIGHT_ID).openPrivateChannel().complete()
		val invite = try { guild.textChannels[0].createInvite().setMaxAge(0).complete().url } catch (ex: Exception) { "None ;-;" }
		channel.sendText { "I have joined ${guild.name}, URL: $invite" }
	}

}