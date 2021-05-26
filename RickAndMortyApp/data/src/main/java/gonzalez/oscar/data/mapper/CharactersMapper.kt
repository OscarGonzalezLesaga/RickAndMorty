package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.domain.Gender
import gonzalez.oscar.domain.Status
import gonzalez.oscar.network.characters.CharactersDTO

fun List<CharactersDTO>.toDomain() = map {
    CartoonCharacter(
        it.name,
        Status.valueOf(it.status.toUpperCase()),
        Gender.valueOf(it.gender.toUpperCase()),
        it.url,
        it.image
    )
}