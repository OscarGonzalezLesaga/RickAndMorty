package gonzalez.oscar.domain.character

import gonzalez.oscar.domain.CartoonCharacter

interface CharactersRepository {

    suspend fun getAllCharacters(): List<CartoonCharacter>?
}