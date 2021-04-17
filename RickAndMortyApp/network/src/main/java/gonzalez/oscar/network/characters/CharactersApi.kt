package gonzalez.oscar.network.characters

import retrofit2.http.GET

interface CharactersApi {

    @GET("character")
    suspend fun getAllCharacters(): AllCharactersDTO
}