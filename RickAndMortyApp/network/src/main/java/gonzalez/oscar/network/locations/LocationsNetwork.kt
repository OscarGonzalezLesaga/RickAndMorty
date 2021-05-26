package gonzalez.oscar.network.locations

import gonzalez.oscar.network.base.BaseNetwork
import gonzalez.oscar.network.base.ResourceData
import gonzalez.oscar.network.base.ResourceData.Success
import gonzalez.oscar.network.base.ServiceErrorDTO.CONNECTION
import gonzalez.oscar.network.base.ServiceErrorDTO.UNAUTHORIZED
import gonzalez.oscar.network.base.ServiceErrorDTO.UNKNOWN
import retrofit2.HttpException
import java.net.UnknownHostException

class LocationsNetwork : BaseNetwork<LocationsApi>(LocationsApi::class.java) {

    suspend fun getAllLocations(page: Int): ResourceData<List<LocationDTO>?> {
        val result = kotlin.runCatching { service.getAllLocations(page) }
        return if (result.isSuccess) {
            Success(result.getOrNull()?.listLocations)
        } else {
            when (result.exceptionOrNull()) {
                is UnknownHostException -> ResourceData.Error(CONNECTION)
                is HttpException -> ResourceData.Error(UNAUTHORIZED)
                else -> ResourceData.Error(UNKNOWN)
            }
        }
    }
}