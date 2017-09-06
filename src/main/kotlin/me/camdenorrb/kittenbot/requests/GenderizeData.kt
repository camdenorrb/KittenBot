package me.camdenorrb.kittenbot.requests


data class GenderizeData(val name: String = "", val gender: String? = "", val probability: String = "N/A", val count: Int = 0) {

	override fun toString(): String = "Name: $name, Gender: ${gender?.capitalize()}, Chance: $probability, Count: $count"

}