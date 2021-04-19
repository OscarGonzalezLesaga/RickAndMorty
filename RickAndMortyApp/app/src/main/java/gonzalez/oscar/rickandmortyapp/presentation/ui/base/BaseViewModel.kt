package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

open class BaseViewModel(private val defaultDispatcher: CoroutineDispatcher) : ViewModel() {

    fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            block()
        }
    }

    fun launchAsync(block: suspend () -> Unit) {
        viewModelScope.launch(defaultDispatcher) {
            block()
        }
    }
}