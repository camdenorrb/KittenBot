package me.camdenorrb.kittenbot.cache

import me.camdenorrb.kittenbot.cmd.Cmd


object Cmds {

	val cmdSet = mutableSetOf<Cmd>()


	fun cleanup() = cmdSet.clear()


	fun register(vararg cmds: Cmd) = cmdSet.addAll(cmds)

	fun unregister(vararg cmds: Cmd) = cmdSet.removeAll(cmds)


	operator fun get(query: String) = cmdSet.find { it.isThis(query) }


	inline fun forEach(block: (Cmd) -> Unit) = cmdSet.forEach(block)

	inline fun filter(predicate: (Cmd) -> Boolean) = cmdSet.filter(predicate)

}