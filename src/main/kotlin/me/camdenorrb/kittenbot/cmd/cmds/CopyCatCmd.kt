package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.bot
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class CopyCatCmd : Cmd(arrayOf("copycat"), "copycat [UUID]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val target = bot.getUserById(args[0]) ?: return false
		channel.sendText { "**!!!** ${target.asMention} stop being a copycat of ${user.asMention} D: **!!!**" }

		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild) = guild.isOwner(user) || super.canExecute(user, channel, guild)

}