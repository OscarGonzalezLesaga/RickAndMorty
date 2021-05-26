package gonzalez.oscar.network.episodes

import gonzalez.oscar.network.base.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApi {

    @GET(NetworkConfig.getAllEpisodesUrl)
    suspend fun getAllEpisodes(@Query("page") page: Int): AllEpisodesDTO
}