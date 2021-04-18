package gonzalez.oscar.domain.character

interface CharactersRepository {

    suspend fun getAllCharacters(): List<CartoonCharacter>?
}