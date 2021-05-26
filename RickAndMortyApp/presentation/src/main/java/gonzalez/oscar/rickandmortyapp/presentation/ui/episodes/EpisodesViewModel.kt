package gonzalez.oscar.rickandmortyapp.presentation.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gonzalez.oscar.data.EpisodesDataSource
import gonzalez.oscar.domain.Episode
import kotlinx.coroutines.flow.Flow

class EpisodesViewModel(episodesDataSource: EpisodesDataSource) : ViewModel() {

    val episodes: Flow<PagingData<Episode>> = Pager(config = PagingConfig(pageSize = 20)) {
        episodesDataSource
    }.flow.cachedIn(viewModelScope)
}