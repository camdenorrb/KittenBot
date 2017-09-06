package me.camdenorrb.kittenbot.ext

import net.dv8tion.jda.core.entities.Message


inline fun Message.safeDelete(onFail: (Exception) -> Unit = {}) {
	try { this.delete().complete() }
	catch (ex: Exception) { onFail(ex) }
}