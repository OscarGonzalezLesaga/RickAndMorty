package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.LocationUniverse
import gonzalez.oscar.network.locations.LocationDTO

fun List<LocationDTO>.toDomain() = map { LocationUniverse(it.name, it.type, it.dimension, it.residents) }