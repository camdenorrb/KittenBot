package me.camdenorrb.kittenbot.cmd.cmds

import me.camdenorrb.kittenbot.cmd.Cmd
import me.camdenorrb.kittenbot.ext.httpRequest
import me.camdenorrb.kittenbot.ext.readJson
import me.camdenorrb.kittenbot.ext.readText
import me.camdenorrb.kittenbot.requests.RandCatUrl
import me.camdenorrb.kittenbot.struct.threadPool
import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.entities.MessageChannel
import net.dv8tion.jda.core.entities.User


private val randomCatRequest = httpRequest("https://random.cat/meow")

class RandomCatCmd : Cmd(arrayOf("rcat", "rkat")) {

	override fun execute(user: User, args: List<String>, guild: Guild, channel: MessageChannel, msg: Message): Boolean {

		threadPool.execute {
			val url = randomCatRequest.readText().readJson<RandCatUrl>().url.replace("http", "https")
			channel.sendMessage(EmbedBuilder().setImage(url).build()).complete()
		}

		return true
	}

}