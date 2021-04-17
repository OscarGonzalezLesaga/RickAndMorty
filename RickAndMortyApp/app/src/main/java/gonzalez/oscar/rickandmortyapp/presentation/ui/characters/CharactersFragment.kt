package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_characters, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObservers()
        initData()
    }

    private fun initObservers() {
        charactersViewModel.dataCharacters.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessViewModel -> Toast.makeText(context, "Hay ${it.data.size} personajes", Toast.LENGTH_SHORT)
                    .show()
                is ErrorViewModel -> Toast.makeText(context, "Error cargando la llamada", Toast.LENGTH_SHORT)
                    .show()
            }

        })

        charactersViewModel.loading.observe(viewLifecycleOwner, { loading ->
            if (loading) {
                Toast.makeText(context, "Cargando", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, "Fin", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun initData() {
        charactersViewModel.getData()
    }
}