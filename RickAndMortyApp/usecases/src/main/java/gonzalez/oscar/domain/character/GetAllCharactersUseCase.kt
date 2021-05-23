package gonzalez.oscar.domain.character

class GetAllCharactersUseCase(private val repository: CharactersRepository) {

    fun invoke() = repository.getAllCharacters()
}