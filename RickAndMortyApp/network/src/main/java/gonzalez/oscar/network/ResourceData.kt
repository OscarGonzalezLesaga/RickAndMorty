package gonzalez.oscar.network

sealed class ResourceData<T>(
    val data: T? = null,
    val error: ServiceErrorDTO? = null
) {

    class Success<T>(data: T) : ResourceData<T>(data)
    class Error<T>(error: ServiceErrorDTO) : ResourceData<T>(error = error)
}

enum class ServiceErrorDTO {
    UNAUTHORIZED, CONNECTION, UNKNOWN
}

