package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cache.GuildSettings
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class SetPrefixCmd : Cmd(arrayOf("setPrefix"), "setPrefix [Prefix Character]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val prefix = args[0][0]
		if (prefix.isLetterOrDigit()) { channel.sendText { "The prefix you provided is a number or a digit!" }; return true }

		GuildSettings[guild]?.prefix = prefix
		GuildSettings.save()

		channel.sendText { "The prefix has been set to `$prefix`" }

		return true
	}


	override fun canExecute(user: User, channel: MessageChannel, guild: Guild)
		= guild.isOwner(user) || super.canExecute(user, channel, guild)

}