package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.send
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.struct.bookmarkChannel
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class PrivateBookmarkCmd : Cmd(arrayOf("pbookmark", "privatebookmark"), "pbookmark [MSG ID] [Bookmark Title]", 2) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val msgID = args[0].toLongOrNull() ?: return false

		val targetMsg = channel.getMessageById(msgID).complete() ?: return false

		val title = buildString { for (i in 1 until args.size) append(args[i]).append(' ') }.trimEnd()


		bookmarkChannel.send {
			appendln("**$title**")
			appendln("Guild: *${targetMsg.guild.name}* Channel: *${targetMsg.channel.name}* Author: *${targetMsg.author.name}*")
			append("```${targetMsg.content.replace('`', '\'')}```")
		}

		return true
	}

}