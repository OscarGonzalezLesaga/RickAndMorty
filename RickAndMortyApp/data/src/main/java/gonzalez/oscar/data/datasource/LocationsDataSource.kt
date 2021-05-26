package gonzalez.oscar.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gonzalez.oscar.data.mapper.toDomain
import gonzalez.oscar.domain.LocationUniverse
import gonzalez.oscar.network.base.ResourceData.Success
import gonzalez.oscar.network.locations.LocationsNetwork

class LocationsDataSource(val network: LocationsNetwork) : PagingSource<Int, LocationUniverse>() {

    override fun getRefreshKey(state: PagingState<Int, LocationUniverse>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationUniverse> {
        val page = params.key ?: 1
        return when (val result = network.getAllLocations(page)) {
            is Success -> LoadResult.Page(
                data = result.data?.toDomain() ?: emptyList(),
                prevKey = if (page != 1) page - 1 else null,
                nextKey = page + 1
            )
            else -> LoadResult.Error(Exception())
        }
    }
}