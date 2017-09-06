package me.camdenorrb.kittenbot.utils

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder


fun clientBlocking(accountType: AccountType, init: JDABuilder.() -> Unit)
	= JDABuilder(accountType).apply(init).buildBlocking()!!