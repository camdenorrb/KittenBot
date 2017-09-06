package me.camdenorrb.kittenbot.requests

import com.google.gson.annotations.SerializedName


data class RandCatUrl(@SerializedName("file") val url: String = "")