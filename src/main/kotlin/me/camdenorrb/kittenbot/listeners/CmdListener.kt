package me.camdenorrb.kittenbot.listeners

import club.minnced.kjda.entities.send
import me.camdenorrb.kittenbot.cache.Cmds
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.ext.safeDelete
import me.camdenorrb.kittenbot.serializable.GuildSetting
import me.camdenorrb.kittenbot.struct.mainDateFormat
import me.camdenorrb.minibus.event.EventWatcher
import me.camdenorrb.minibus.listener.MiniListener
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.util.*

class CmdListener : MiniListener {

	@EventWatcher
	fun onMessageReceived(event: MessageReceivedEvent) {

		val msg = event.message
		val author = msg.author

		val channel = msg.channel
		val rawContent = msg.rawContent

		val guild = msg.guild ?: return
		val guildSettings = GuildSettings.settings.getOrPut(guild.idLong, { GuildSetting() })


		if (rawContent.length == 1 || rawContent.firstOrNull() != guildSettings.prefix) return


		val args = rawContent.substring(1).split(' ').toMutableList()
		val cmd = Cmds[args.removeAt(0)]


		if (cmd == null || !cmd.canExecute(author, channel, guild)) return

		msg.safeDelete()

		if (args.size < cmd.minArgs || !cmd.execute(author, args, guild, channel, msg)) {
			channel.send { appendln("```YAML").append("Usage: #${cmd.usage}").append("```") }
		}

		println("[${mainDateFormat.format(Date())}] ${guild.name}:${channel.name} ${author.name}#${author.discriminator}: \"$rawContent\"")
	}

}