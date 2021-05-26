package gonzalez.oscar.network.locations

import com.google.gson.annotations.SerializedName
import gonzalez.oscar.network.base.BaseInfoDTO

data class AllLocationsDTO(
    @SerializedName("info") val baseInfo: BaseInfoDTO,
    @SerializedName("results") val listLocations: List<LocationDTO>
)

data class LocationDTO(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>
)