package gonzalez.oscar.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gonzalez.oscar.data.mapper.toDomain
import gonzalez.oscar.domain.Episode
import gonzalez.oscar.network.base.ResourceData.Success
import gonzalez.oscar.network.episodes.EpisodesNetwork

class EpisodesDataSource(private val network: EpisodesNetwork) : PagingSource<Int, Episode>() {

    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        val page = params.key ?: 1
        return when (val allEpisodes = network.getAllEpisodes(page)) {
            is Success -> LoadResult.Page(
                data = allEpisodes.data?.toDomain() ?: emptyList(),
                prevKey = if (page != 1) page - 1 else null,
                nextKey = page + 1
            )
            else -> LoadResult.Error(Exception())
        }
    }
}