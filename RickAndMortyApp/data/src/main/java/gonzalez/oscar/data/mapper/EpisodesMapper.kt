package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.Episode
import gonzalez.oscar.network.episodes.EpisodesDTO

fun List<EpisodesDTO>.toDomain() = map { Episode(it.name, it.number, it.date, it.charactersImages) }