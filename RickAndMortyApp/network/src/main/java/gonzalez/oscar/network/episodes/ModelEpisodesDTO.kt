package gonzalez.oscar.network.episodes

import com.google.gson.annotations.SerializedName
import gonzalez.oscar.network.base.BaseInfoDTO

data class AllEpisodesDTO(
    @SerializedName("info") val baseInfo: BaseInfoDTO,
    @SerializedName("results") val listEpisodes: List<EpisodesDTO>
)

data class EpisodesDTO(
    val id: Int,
    val name: String,
    @SerializedName("air_date") val date: String,
    @SerializedName("episode") val number: String,
    @SerializedName("characters") val charactersImages: List<String>
)