package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gonzalez.oscar.domain.character.GetAllCharactersUseCase
import gonzalez.oscar.rickandmortyapp.extensionsfunction.launch
import gonzalez.oscar.rickandmortyapp.extensionsfunction.launchAsync
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.Loading
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.StateCharacters
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel

class CharactersViewModel(private val allCharacters: GetAllCharactersUseCase) : ViewModel() {

    private var _dataCharacters = MutableLiveData<StateCharacters>()
    val dataCharacters: LiveData<StateCharacters>
        get() = _dataCharacters

    fun getData() {
        launch {
            _dataCharacters.value = Loading
            launchAsync {
                val result = allCharacters.invoke()
                _dataCharacters.postValue(
                    if (result.isNullOrEmpty()) {
                        ErrorViewModel()
                    } else {
                        SuccessViewModel(result)
                    }
                )
            }
        }
    }
}