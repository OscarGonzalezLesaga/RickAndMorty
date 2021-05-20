package gonzalez.oscar.local.characters

class CharactersLocal(val dao: CharactersDao) {

    fun getAllCharacters(): List<CharactersDob> {
        return dao.getAll()
    }
}