package me.camdenorrb.kittenbot.cache

import me.camdenorrb.kittenbot.ext.readJson
import me.camdenorrb.kittenbot.ext.writeJsonTo
import me.camdenorrb.kittenbot.serializable.GuildSetting
import me.camdenorrb.kittenbot.struct.settingsFile
import net.dv8tion.jda.core.entities.Guild


object GuildSettings {

	val settings = settingsFile.readJson(GuildSettingsMap()).map

	operator fun get(guild: Guild) = settings[guild.idLong]

	fun save() = GuildSettingsMap(settings).writeJsonTo(settingsFile)

}


data class GuildSettingsMap(val map: MutableMap<Long, GuildSetting> = mutableMapOf())