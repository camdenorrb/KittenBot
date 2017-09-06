package me.camdenorrb.kittenbot.ext

import me.camdenorrb.kittenbot.cache.GuildSettings
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.User


fun Guild.isOwner(user: User) = GuildSettings[this]?.owners?.contains(user) ?: false