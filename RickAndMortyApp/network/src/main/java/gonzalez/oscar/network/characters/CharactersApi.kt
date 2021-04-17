package gonzalez.oscar.network.characters

import gonzalez.oscar.network.NetworkConfig.getAllCharactersUrl
import retrofit2.http.GET

interface CharactersApi {

    @GET(getAllCharactersUrl)
    suspend fun getAllCharacters(): AllCharactersDTO
}