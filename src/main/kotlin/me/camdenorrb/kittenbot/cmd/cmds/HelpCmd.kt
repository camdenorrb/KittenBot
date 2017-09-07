package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cache.Cmds
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

// Send privately through embedded message, since you can do that without permissionz
class HelpCmd : Cmd(arrayOf("kittenhelp")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val cmdInfo = Cmds.filter { it.canExecute(user, channel, guild) }.map {
			"${it.mainCmd}${if (it.usage != null) ": #${it.usage}" else ""}"
		}.sortedBy { it.length }


		val help = buildString {
			appendln("```Yaml").appendln("CmdHelp:")
			appendln(cmdInfo.joinToString("\n").prependIndent())
			appendln("```")
		}


		try { user.openPrivateChannel().complete().sendText { help } }
		catch (ex: Exception) { channel.sendText { "Can't privately send you messages due to privacy settings!" } }

		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild)
		= guild.isOwner(user) || super.canExecute(user, channel, guild)

}