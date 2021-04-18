package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import gonzalez.oscar.domain.character.CartoonCharacter

sealed class StateCharacters

data class ErrorViewModel(val message: String? = null) : StateCharacters()
data class SuccessViewModel(val data: List<CartoonCharacter>) : StateCharacters()
