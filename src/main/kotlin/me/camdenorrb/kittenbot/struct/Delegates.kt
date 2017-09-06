package me.camdenorrb.kittenbot.struct

import me.camdenorrb.kittenbot.bot


val privateGuild by lazy { bot.getGuildById(PRIVATE_GUILD_ID)!! }

val bookmarkChannel by lazy { privateGuild.getTextChannelById(BOOKMARK_CHANNEL_ID)!! }