package gonzalez.oscar.network.characters

import com.google.gson.annotations.SerializedName
import gonzalez.oscar.network.base.BaseInfoDTO

data class OriginDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class LocationDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class CharactersDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: OriginDTO,
    @SerializedName("location") val location: LocationDTO,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)

data class AllCharactersDTO(
    @SerializedName("info") val baseInfo: BaseInfoDTO,
    @SerializedName("results") val listCharacters: List<CharactersDTO>
)