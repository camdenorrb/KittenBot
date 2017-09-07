package me.camdenorrb.kittenbot.cmd.cmds

import club.minnced.kjda.entities.sendText
import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.httpRequest
import me.camdenorrb.kittenbot.ext.isOwner
import me.camdenorrb.kittenbot.ext.readJson
import me.camdenorrb.kittenbot.ext.readText
import me.camdenorrb.kittenbot.requests.GenderizeData
import me.camdenorrb.kittenbot.struct.threadPool
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


private const val API_URL = "https://api.genderize.io/?name="

class GenderCmd : Cmd(arrayOf("gender"), "gender [Name]", 1) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		threadPool.execute {
			val gender = httpRequest("$API_URL${args[0]}").readText().readJson<GenderizeData>()
			channel.sendText { gender.toString() }
		}

		return true
	}

	override fun canExecute(user: User, channel: MessageChannel, guild: Guild)
		= guild.isOwner(user) || super.canExecute(user, channel, guild)

}