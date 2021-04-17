package gonzalez.oscar.domain.character

data class CartoonCharacter(
    val name: String,
    val status: Status,
    val gender: Gender,
    val url: String,
    val image: String
)

enum class Status {
    ALIVE, DEAD, UNKNOWN
}

enum class Gender {
    FEMALE, MALE, GENDERLESS, UNKNOWN
}

inline fun <reified T : Enum<T>, V> ((T) -> V).findValue(value: V): T? {
    return enumValues<T>().firstOrNull { this(it) == value }
}
