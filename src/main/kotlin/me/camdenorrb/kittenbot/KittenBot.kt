package me.camdenorrb.kittenbot

import club.minnced.kjda.game
import club.minnced.kjda.token
import me.camdenorrb.kittenbot.cache.Cmds
import me.camdenorrb.kittenbot.cmd.cmds.*
import me.camdenorrb.kittenbot.eventmanager.MiniEventManager
import me.camdenorrb.kittenbot.listeners.CmdListener
import me.camdenorrb.kittenbot.listeners.JoinListener
import me.camdenorrb.kittenbot.listeners.ShutdownListener
import me.camdenorrb.kittenbot.listeners.SpaceListener
import me.camdenorrb.kittenbot.struct.timer
import me.camdenorrb.kittenbot.tasks.SettingsSaveTask
import me.camdenorrb.kittenbot.utils.clientBlocking
import net.dv8tion.jda.core.AccountType.BOT
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.requests.SessionReconnectQueue
import java.io.File


val bot: JDA = clientBlocking(BOT) {

	game { "WIP" }
	token { File("Token.txt").apply { createNewFile() }.readText() }

	setEventManager(MiniEventManager())
	setReconnectQueue(SessionReconnectQueue())
	addEventListener(CmdListener(), JoinListener(), SpaceListener(), ShutdownListener())

	//for (i in 0 until 10) { println("Login $i"); Thread.sleep(5000); useSharding(i, 10) }
}


fun main(args: Array<String>) {

	timer.scheduleAtFixedRate(SettingsSaveTask(), 300_000, 3_600_000)
	Cmds.register(HelpCmd(), CopyCatCmd(), PrivateBookmarkCmd(), RandomCatCmd(), ClearCmd(), MeowCmd(), ShutDownCmd(), SetPrefixCmd(), GenderCmd(), AddOwnersCmd())

	println("Finished initializing, you can invite me by using: ${bot.asBot().getInviteUrl()}\n")
}

