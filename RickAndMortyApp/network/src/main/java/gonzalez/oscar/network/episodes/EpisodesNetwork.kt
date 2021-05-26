package gonzalez.oscar.network.episodes

import gonzalez.oscar.network.base.BaseNetwork
import gonzalez.oscar.network.base.ResourceData
import gonzalez.oscar.network.base.ResourceData.Success
import gonzalez.oscar.network.base.ServiceErrorDTO.CONNECTION
import gonzalez.oscar.network.base.ServiceErrorDTO.UNAUTHORIZED
import gonzalez.oscar.network.base.ServiceErrorDTO.UNKNOWN
import retrofit2.HttpException
import java.net.UnknownHostException

class EpisodesNetwork : BaseNetwork<EpisodesApi>(EpisodesApi::class.java) {

    suspend fun getAllEpisodes(page: Int): ResourceData<List<EpisodesDTO>?> {
        val result = kotlin.runCatching { service.getAllEpisodes(page) }
        return if (result.isSuccess) {
            Success(result.getOrNull()?.listEpisodes)
        } else {
            when (result.exceptionOrNull()) {
                is UnknownHostException -> ResourceData.Error(CONNECTION)
                is HttpException -> ResourceData.Error(UNAUTHORIZED)
                else -> ResourceData.Error(UNKNOWN)
            }
        }
    }
}