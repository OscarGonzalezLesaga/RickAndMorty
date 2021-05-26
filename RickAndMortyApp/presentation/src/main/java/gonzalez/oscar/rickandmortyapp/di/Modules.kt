package gonzalez.oscar.rickandmortyapp.di

import gonzalez.oscar.data.CharactersDataSource
import gonzalez.oscar.data.EpisodesDataSource
import gonzalez.oscar.domain.character.GetAllCharactersUseCase
import gonzalez.oscar.network.characters.CharactersNetwork
import gonzalez.oscar.network.episodes.EpisodesNetwork
import gonzalez.oscar.rickandmortyapp.presentation.ui.characters.CharactersViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.episodes.EpisodesViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesRickAndMorty = listOf(module {
    viewModel {
        CharactersViewModel(get())
    }

    viewModel {
        EpisodesViewModel(get())
    }

    viewModel {
        LocationsViewModel()
    }
}, module {
    single { GetAllCharactersUseCase(get()) }
    single { CharactersDataSource(get()) }
    single { CharactersNetwork() }
    single { EpisodesDataSource(get()) }
    single { EpisodesNetwork() }
})