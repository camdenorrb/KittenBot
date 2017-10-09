package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.send
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.cmd.Cmd
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


class ListOwnersCmd: Cmd(arrayOf("listowners")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {
		val owners = GuildSettings[guild]?.owners?.map { "${it.name}:${it.discriminator}" } ?: return false
		channel.send { appendln("```YAML").append("Owners: $owners```") }
		return true
	}

}