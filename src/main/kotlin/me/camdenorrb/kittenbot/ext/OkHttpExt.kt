package me.camdenorrb.kittenbot.ext

import me.camdenorrb.kittenbot.struct.okhttp
import okhttp3.Request


fun httpRequest(url: String) = httpRequest { url(url) }

fun httpRequest(block: Request.Builder.() -> Unit) = Request.Builder().also(block).build()!!


fun Request.readText() = okhttp.newCall(this).execute().body()!!.string()!!