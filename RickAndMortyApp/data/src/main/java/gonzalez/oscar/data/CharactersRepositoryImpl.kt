package gonzalez.oscar.data

import gonzalez.oscar.data.mapper.toDomain
import gonzalez.oscar.domain.character.CartoonCharacter
import gonzalez.oscar.domain.character.CharactersRepository
import gonzalez.oscar.network.ResourceData.Error
import gonzalez.oscar.network.ResourceData.Success
import gonzalez.oscar.network.characters.CharactersNetwork

class CharactersRepositoryImpl(private val network: CharactersNetwork) : CharactersRepository {

    override suspend fun getAllCharacters(): List<CartoonCharacter>? {
        return when (val allCharacters = network.getAllCharacters()) {
            is Success -> allCharacters.data?.map { it.toDomain() }
            is Error -> null
        }
    }
}