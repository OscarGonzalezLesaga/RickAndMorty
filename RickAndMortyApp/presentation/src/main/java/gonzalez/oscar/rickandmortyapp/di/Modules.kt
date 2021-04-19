package gonzalez.oscar.rickandmortyapp.di

import gonzalez.oscar.data.CharactersRepositoryImpl
import gonzalez.oscar.domain.character.CharactersRepository
import gonzalez.oscar.domain.character.GetAllCharactersUseCase
import gonzalez.oscar.network.characters.CharactersNetwork
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
        EpisodesViewModel()
    }

    viewModel {
        LocationsViewModel()
    }
}, module {
    single { GetAllCharactersUseCase(get()) }
    single<CharactersRepository> { CharactersRepositoryImpl(get()) }
    single { CharactersNetwork() }
})