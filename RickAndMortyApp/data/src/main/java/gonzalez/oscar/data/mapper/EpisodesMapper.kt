package gonzalez.oscar.data.mapper

import gonzalez.oscar.domain.Episode
import gonzalez.oscar.network.episodes.EpisodesDTO

fun EpisodesDTO.toDomain() = Episode(name, number, date, charactersImages)