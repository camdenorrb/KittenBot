package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.send
import me.camdenorrb.kittenbot.bot
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.cmd.Cmd
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


class RemOwnersCmd : Cmd(arrayOf("removeowners"), "removeOwners [UUID...]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val owners = GuildSettings[guild]?.owners ?: return false
		val changed = args.mapNotNull { it.toLongOrNull()?.let { bot.getUserById(it) } }.filter { owners.remove(it) }

		channel.send { appendln("```Yaml").append("Removed: ${changed.map { "${it.name}#${it.discriminator}" }} from Owners!```") }

		GuildSettings.save()

		return true
	}

}