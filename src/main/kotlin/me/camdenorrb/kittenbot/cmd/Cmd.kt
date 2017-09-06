package me.camdenorrb.kittenbot.cmd

import me.camdenorrb.kittenbot.struct.MIDNIGHT_ID
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


abstract class Cmd(val aliases: Array<String>, val usage: String? = null, var minArgs: Int = 0) {

	open val mainCmd = aliases.firstOrNull() ?: "Unknown"


	open fun isThis(cmd: String) = aliases.any { it.equals(cmd, true) }

	open fun canExecute(user: User, channel: MessageChannel, guild: Guild) = user.idLong == MIDNIGHT_ID


	fun canExecute(msg: Message) = canExecute(msg.author, msg.channel, msg.guild)


	abstract fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean

}