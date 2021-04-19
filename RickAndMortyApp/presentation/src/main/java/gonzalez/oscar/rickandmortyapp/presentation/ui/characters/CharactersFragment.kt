package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.BaseFragment
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.toast
import gonzalez.oscar.rickandmortyapp.presentation.utils.hide
import gonzalez.oscar.rickandmortyapp.presentation.utils.show
import kotlinx.android.synthetic.main.fragment_characters.list_characters
import kotlinx.android.synthetic.main.fragment_characters.loading_view
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {

    private val charactersViewModel: CharactersViewModel by viewModel()

    private val adapter = CharactersViewAdapter()

    override fun getRootView() = R.layout.fragment_characters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObservers()
        initData()
    }

    private fun initObservers() {
        charactersViewModel.dataCharacters.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessViewModel -> adapter.loadCharacters(it.data)
                is ErrorViewModel -> toast(getString(R.string.error_load_characters))
            }

        })

        charactersViewModel.loading.observe(viewLifecycleOwner, { load ->
            if (load) {
                loading_view.show()
            } else {
                loading_view.hide()
            }
        })
    }

    private fun initData() {
        charactersViewModel.getData()
        list_characters.layoutManager = LinearLayoutManager(context)
        list_characters.adapter = adapter
    }
}