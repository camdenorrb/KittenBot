package me.camdenorrb.kittenbot.serializable

import net.dv8tion.jda.core.entities.User


data class GuildSetting(var prefix: Char = '!', val owners: MutableSet<User> = mutableSetOf())