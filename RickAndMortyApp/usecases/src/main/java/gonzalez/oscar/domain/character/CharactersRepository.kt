package gonzalez.oscar.domain.character

import gonzalez.oscar.domain.CartoonCharacter

interface CharactersRepository {

    fun getAllCharacters(): List<CartoonCharacter>?
}