package gonzalez.oscar.rickandmortyapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EpisodesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is episodes Fragment"
    }
    val text: LiveData<String> = _text
}