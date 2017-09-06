package me.camdenorrb.kittenbot.tasks

import me.camdenorrb.kittenbot.cache.GuildSettings
import java.util.*


class SettingsSaveTask : TimerTask() {

	override fun run() = GuildSettings.save()

}