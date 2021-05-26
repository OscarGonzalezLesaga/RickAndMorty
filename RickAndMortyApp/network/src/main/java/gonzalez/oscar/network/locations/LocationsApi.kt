package gonzalez.oscar.network.locations

import gonzalez.oscar.network.base.NetworkConfig.getAllLocationsUrl
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApi {

    @GET(getAllLocationsUrl)
    suspend fun getAllLocations(@Query("page") page: Int): AllLocationsDTO
}