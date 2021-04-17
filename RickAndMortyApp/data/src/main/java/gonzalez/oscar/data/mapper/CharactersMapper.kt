package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.character.CartoonCharacter
import gonzalez.oscar.domain.character.Gender
import gonzalez.oscar.domain.character.Status
import gonzalez.oscar.network.characters.CharactersDTO

fun CharactersDTO.toDomain() = CartoonCharacter(
    name,
    Status.valueOf(status.toUpperCase()),
    Gender.valueOf(gender.toUpperCase()),
    url,
    image
)