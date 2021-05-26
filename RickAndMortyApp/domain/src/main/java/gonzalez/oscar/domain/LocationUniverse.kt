package gonzalez.oscar.domain

data class LocationUniverse(
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>
)
