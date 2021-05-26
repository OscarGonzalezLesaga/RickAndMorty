package gonzalez.oscar.network.characters

import gonzalez.oscar.network.base.NetworkConfig.getAllCharactersUrl
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET(getAllCharactersUrl)
    suspend fun getAllCharacters(@Query("page") page: Int): AllCharactersDTO
}