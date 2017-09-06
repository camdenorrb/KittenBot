package me.camdenorrb.kittenbot.cmd.cmds

import me.camdenorrb.kittenbot.bot
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.events.KatBotShutdownEvent
import me.camdenorrb.kittenbot.struct.minibus
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User
import kotlin.system.exitProcess

class ShutDownCmd : Cmd(arrayOf("shutdown")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {
		minibus(KatBotShutdownEvent())
		bot.shutdown(); exitProcess(0)
	}

}