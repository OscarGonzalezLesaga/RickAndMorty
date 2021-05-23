package gonzalez.oscar.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gonzalez.oscar.data.mapper.toDomain
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.network.ResourceData.Success
import gonzalez.oscar.network.characters.CharactersNetwork

class CharactersRemotePagingSource(private val network: CharactersNetwork = CharactersNetwork()) :
    PagingSource<Int, CartoonCharacter>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CartoonCharacter> {
        val page = params.key ?: 1
        return when (val allCharacters = network.getAllCharacters(page)) {
            is Success -> LoadResult.Page(
                data = allCharacters.data?.map { it.toDomain() } ?: emptyList(),
                prevKey = if (page != 1) page - 1 else null,
                nextKey = page + 1
            )
            else -> LoadResult.Error(Exception())
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CartoonCharacter>): Int? {
        TODO("Not yet implemented")
    }
}