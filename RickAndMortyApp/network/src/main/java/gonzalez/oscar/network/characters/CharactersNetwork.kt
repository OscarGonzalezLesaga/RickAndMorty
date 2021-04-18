package gonzalez.oscar.network.characters

import gonzalez.oscar.network.BaseNetwork
import gonzalez.oscar.network.ResourceData
import gonzalez.oscar.network.ResourceData.Success
import gonzalez.oscar.network.ServiceErrorDTO.CONNECTION
import gonzalez.oscar.network.ServiceErrorDTO.UNAUTHORIZED
import gonzalez.oscar.network.ServiceErrorDTO.UNKNOWN
import retrofit2.HttpException
import java.net.UnknownHostException

class CharactersNetwork : BaseNetwork<CharactersApi>(CharactersApi::class.java) {

    suspend fun getAllCharacters(): ResourceData<List<CharactersDTO>?> {
        val result = kotlin.runCatching { service.getAllCharacters() }
        return if (result.isSuccess) {
            Success(result.getOrNull()?.listCharacters)
        } else {
            when (result.exceptionOrNull()) {
                is UnknownHostException -> ResourceData.Error(CONNECTION)
                is HttpException -> ResourceData.Error(UNAUTHORIZED)
                else -> ResourceData.Error(UNKNOWN)
            }
        }
    }
}