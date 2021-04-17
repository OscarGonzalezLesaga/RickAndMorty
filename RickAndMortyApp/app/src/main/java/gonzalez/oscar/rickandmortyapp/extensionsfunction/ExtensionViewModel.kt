package gonzalez.oscar.rickandmortyapp.extensionsfunction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun ViewModel.launch(block: suspend () -> Unit) {
    viewModelScope.launch {
        block()
    }
}

suspend fun ViewModel.launchAsync(block: suspend () -> Unit) {
    withContext(Dispatchers.IO) {
        block()
    }
}