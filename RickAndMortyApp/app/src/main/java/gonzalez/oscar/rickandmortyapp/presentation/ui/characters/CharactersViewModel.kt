package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import gonzalez.oscar.domain.character.GetAllCharactersUseCase
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.StateCharacters
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CharactersViewModel(
    private val allCharacters: GetAllCharactersUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseViewModel(defaultDispatcher) {

    private var _dataCharacters = MutableLiveData<StateCharacters>()
    val dataCharacters: LiveData<StateCharacters>
        get() = _dataCharacters

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun getData() {
        launch {
            _loading.value = true
            launchAsync {
                val result = allCharacters.invoke()
                _dataCharacters.postValue(
                    if (result.isNullOrEmpty()) {
                        ErrorViewModel()
                    } else {
                        SuccessViewModel(result)
                    }
                )
                _loading.postValue(false)
            }
        }
    }
}