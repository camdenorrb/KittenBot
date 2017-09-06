package me.camdenorrb.kittenbot.struct

import com.google.gson.GsonBuilder
import me.camdenorrb.kittenbot.gson.UserAdapter
import me.camdenorrb.minibus.MiniBus
import net.dv8tion.jda.core.entities.User
import okhttp3.OkHttpClient
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.TimeZone.getTimeZone
import java.util.concurrent.Executors


const val MIDNIGHT_ID = 170232582770917376


const val STEM_GUILD_ID = 273944235143593984

const val STEM_SPACE_CHANNEL_ID = 276572985178062848


const val PRIVATE_GUILD_ID = 274053384967946240

const val BOOKMARK_CHANNEL_ID = 354499562930569216


const val NASA_BOT_NAME = "NASA - Image of the Day"


val timer = Timer()

val minibus = MiniBus()

val okhttp = OkHttpClient()

val settingsFile = File("Settings.json")


val threadPool = Executors.newCachedThreadPool()!!

val mainDateFormat = SimpleDateFormat("yyyy/MM/dd h:mm:ss a").apply { timeZone = getTimeZone("CST") }


val gson = GsonBuilder()
	.setPrettyPrinting()
	.enableComplexMapKeySerialization()
	.registerTypeAdapter(User::class.java, UserAdapter())
	.create()!!