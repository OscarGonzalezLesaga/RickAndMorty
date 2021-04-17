package gonzalez.oscar.rickandmortyapp.di

import gonzalez.oscar.rickandmortyapp.presentation.ui.episodes.EpisodesViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.characters.CharactersViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesRickAndMorty = listOf(module {
    viewModel {
        CharactersViewModel()
    }

    viewModel {
        EpisodesViewModel()
    }

    viewModel {
        LocationsViewModel()
    }
})