package me.camdenorrb.kittenbot.utils

import net.dv8tion.jda.core.EmbedBuilder


fun jembed(block: EmbedBuilder.() -> Unit) = EmbedBuilder().also(block).build()