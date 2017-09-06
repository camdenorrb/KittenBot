package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.isOwner
import me.camdenorrb.kittenbot.ext.safeDelete
import me.camdenorrb.kittenbot.struct.threadPool
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User

class ClearCmd : Cmd(arrayOf("clear"), "clear [1-100]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		val amount = args[0].toIntOrNull()?.takeIf { it in 1..100 } ?: return false
		val history = channel.history.retrievePast(amount).complete()


		threadPool.execute {

			history.filter { !it.isPinned }.forEach {
				it.safeDelete { channel.sendText { "Can't delete messages!" }; return@execute }
				Thread.sleep(500)
			}

		}


		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild) = guild.isOwner(user) || super.canExecute(user, channel, guild)

}