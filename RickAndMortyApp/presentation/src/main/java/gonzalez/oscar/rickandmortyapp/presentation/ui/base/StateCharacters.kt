package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import androidx.paging.PagingData
import gonzalez.oscar.domain.CartoonCharacter

sealed class StateCharacters

data class ErrorViewModel(val message: String? = null) : StateCharacters()
data class SuccessViewModel(val data: PagingData<CartoonCharacter>) : StateCharacters()
