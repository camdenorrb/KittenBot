package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class MilliCmd : Cmd(arrayOf("milli"), "milli [Centimeters]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {
		val millimeters = args[0].toIntOrNull() ?: return false
		channel.sendText { "`$millimeters`cm is `${millimeters * 10}` millimeters, don't be a dumbo like Cam." }
		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild): Boolean {
		return guild.isOwner(user) || super.canExecute(user, channel, guild)
	}

}