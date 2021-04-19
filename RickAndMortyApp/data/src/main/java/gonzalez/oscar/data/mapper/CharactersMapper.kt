package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.domain.Gender
import gonzalez.oscar.domain.Status
import gonzalez.oscar.network.characters.CharactersDTO

fun CharactersDTO.toDomain() = CartoonCharacter(
    name,
    Status.valueOf(status.toUpperCase()),
    Gender.valueOf(gender.toUpperCase()),
    url,
    image
)