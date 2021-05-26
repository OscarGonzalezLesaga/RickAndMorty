package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gonzalez.oscar.data.CharactersDataSource
import gonzalez.oscar.domain.CartoonCharacter
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(
    private val charactersDataSource: CharactersDataSource
) : ViewModel() {

    val characters: Flow<PagingData<CartoonCharacter>> = Pager(config = PagingConfig(pageSize = 20)) {
        charactersDataSource
    }.flow.cachedIn(viewModelScope)
}