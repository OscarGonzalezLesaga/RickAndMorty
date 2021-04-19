package gonzalez.oscar.domain.character

class GetAllCharactersUseCase(private val repository: CharactersRepository) {

    suspend fun invoke() = repository.getAllCharacters()
}