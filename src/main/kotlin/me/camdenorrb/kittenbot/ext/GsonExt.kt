package me.camdenorrb.kittenbot.ext

import me.camdenorrb.kittenbot.struct.gson
import java.io.File
import java.lang.reflect.Type


fun Any.toJson(): String = gson.toJson(this)

fun Any.writeJsonTo(file: File) = file.writeText(this.toJson())


inline fun <reified T> String.readJson(): T = gson.fromJson(this, T::class.java)

inline fun <reified T> String.readJson(type: Type): T = gson.fromJson<T>(this, type)


inline fun <reified T> File.readJson(): T {
	if (this.exists().not()) this.createNewFile()
	return gson.fromJson(this.readText(), T::class.java)
}

inline fun <reified T> File.readJson(onDoesNotExist: () -> T): T {
	if (this.exists().not()) return onDoesNotExist()
	return gson.fromJson(this.readText(), T::class.java)
}

inline fun <reified T> File.readJson(defaultValue: T): T {
	if (this.exists().not()) return defaultValue.also { it?.writeJsonTo(this@readJson) }
	return gson.fromJson(this.readText(), T::class.java)
}