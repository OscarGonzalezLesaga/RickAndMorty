package gonzalez.oscar.domain

import java.io.Serializable

data class CartoonCharacter(
    val name: String,
    val status: Status,
    val gender: Gender,
    val url: String,
    val image: String
) : Serializable

enum class Status {
    ALIVE, DEAD, UNKNOWN
}

enum class Gender {
    FEMALE, MALE, GENDERLESS, UNKNOWN
}
