package gonzalez.oscar.domain

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
