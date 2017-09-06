package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.bot
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.cmd.Cmd
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class AddOwnersCmd : Cmd(arrayOf("addOwners"), "addOwners [UUID]...", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val owners = GuildSettings[guild]?.owners ?: return false
		val newOwners = args.map { it.toLongOrNull()?.let { bot.getUserById(it) } ?: return false }.filter { owners.add(it) }

		channel.sendText { "Added `${newOwners.map { "${it.name}#${it.discriminator}" }}` to Owners!" }

		GuildSettings.save()

		return true
	}

}