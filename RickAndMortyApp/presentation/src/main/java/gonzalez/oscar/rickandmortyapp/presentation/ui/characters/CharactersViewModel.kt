package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gonzalez.oscar.data.CharactersRemotePagingSource
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(
    private val charactersRemotePagingSource: CharactersRemotePagingSource,
    defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseViewModel(defaultDispatcher) {

    val characters: Flow<PagingData<CartoonCharacter>> = Pager(config = PagingConfig(pageSize = 20)) {
        charactersRemotePagingSource
    }.flow.cachedIn(viewModelScope)
}