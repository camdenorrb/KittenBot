package me.camdenorrb.kittenbot.cmd.cmds

import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.utils.jembed
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


private val message = jembed {
	setImage("https://media.tenor.com/images/6aa432caad8e3272d21a68ead3629853/tenor.gif")
}


class SlapCmd : Cmd(arrayOf("slap")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {
		channel.sendMessage(message).complete()
		return true
	}

}