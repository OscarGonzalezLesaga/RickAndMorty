package gonzalez.oscar.network.characters

import gonzalez.oscar.network.base.BaseNetwork
import gonzalez.oscar.network.base.ResourceData
import gonzalez.oscar.network.base.ResourceData.Success
import gonzalez.oscar.network.base.ServiceErrorDTO.CONNECTION
import gonzalez.oscar.network.base.ServiceErrorDTO.UNAUTHORIZED
import gonzalez.oscar.network.base.ServiceErrorDTO.UNKNOWN
import retrofit2.HttpException
import java.net.UnknownHostException

class CharactersNetwork : BaseNetwork<CharactersApi>(CharactersApi::class.java) {

    suspend fun getAllCharacters(page: Int): ResourceData<List<CharactersDTO>?> {
        val result = kotlin.runCatching { service.getAllCharacters(page) }
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