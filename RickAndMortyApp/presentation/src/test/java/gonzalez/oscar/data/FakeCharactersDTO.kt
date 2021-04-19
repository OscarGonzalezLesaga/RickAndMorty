package gonzalez.oscar.data

import gonzalez.oscar.network.characters.CharactersDTO
import gonzalez.oscar.network.characters.LocationDTO
import gonzalez.oscar.network.characters.OriginDTO
import kotlin.random.Random

class FakeCharactersDTO {
    companion object {

        private fun getFakeCharacter() =
            CharactersDTO(
                getId(),
                getName(),
                getStatus(),
                "",
                "",
                getGender(),
                OriginDTO("", ""),
                LocationDTO("", ""),
                getImage(),
                emptyList(),
                "",
                ""
            )

        fun getListOfFakeCharacters(numberCharacters: Int) = (0..numberCharacters).map { getFakeCharacter() }

        private fun getId() = Random.nextInt()
        private fun getName() = fakeNames[Random.nextInt(5)]
        private fun getStatus() = fakeState[Random.nextInt(2)]
        private fun getImage() = fakeImageUrl[Random.nextInt(4)]
        private fun getGender() = fakeGender[Random.nextInt(3)]

        private val fakeNames = listOf("Rick", "Morty", "Summer", "Beth", "Jerry", "Agency Director")
        private val fakeState = listOf("Alive", "Dead", "Unknown")
        private val fakeGender = listOf("Female", "Male", "Genderless", "unknown")
        private val fakeImageUrl = listOf(
            "https://rickandmortyapi.com/api/character/avatar/9.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
        )
    }
}