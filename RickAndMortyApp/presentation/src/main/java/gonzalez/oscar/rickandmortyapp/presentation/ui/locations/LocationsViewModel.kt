package gonzalez.oscar.rickandmortyapp.presentation.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gonzalez.oscar.data.datasource.LocationsDataSource
import gonzalez.oscar.domain.LocationUniverse
import kotlinx.coroutines.flow.Flow

class LocationsViewModel(locationsDataSource: LocationsDataSource) : ViewModel() {

    val locations: Flow<PagingData<LocationUniverse>> = Pager(config = PagingConfig(pageSize = 20)) {
        locationsDataSource
    }.flow.cachedIn(viewModelScope)
}