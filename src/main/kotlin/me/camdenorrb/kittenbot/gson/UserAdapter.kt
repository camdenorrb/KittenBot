package me.camdenorrb.kittenbot.gson

import com.google.gson.*
import me.camdenorrb.kittenbot.bot
import net.dv8tion.jda.core.entities.User
import java.lang.reflect.Type

class UserAdapter : JsonSerializer<User>, JsonDeserializer<User> {

	override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext)
		= bot.getUserById(json.asJsonObject.get("uuid").asLong)!!

	override fun serialize(user: User, typeOfSrc: Type, context: JsonSerializationContext) = JsonObject().apply {
		addProperty("user", user.name)
		addProperty("discriminator", user.discriminator)
		addProperty("uuid", user.idLong)
	}

}