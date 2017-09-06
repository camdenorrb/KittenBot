package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class MeowCmd : Cmd(arrayOf("meow")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {
		channel.sendText { "Mew meow mew! :cat:" }
		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild) = guild.isOwner(user) || super.canExecute(user, channel, guild)

}