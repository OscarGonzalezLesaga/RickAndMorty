package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.FragmentCharactersBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel
import gonzalez.oscar.rickandmortyapp.presentation.utils.hide
import gonzalez.oscar.rickandmortyapp.presentation.utils.show
import gonzalez.oscar.rickandmortyapp.presentation.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModel()

    private val adapter = CharactersViewAdapter()
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObservers()
        initData()
    }

    private fun initObservers() {
        charactersViewModel.dataCharacters.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessViewModel -> adapter.submitList(it.data)
                is ErrorViewModel -> toast(getString(R.string.error_load_characters))
            }

        })

        charactersViewModel.loading.observe(viewLifecycleOwner, { load ->
            if (load) {
                binding.loadingView.show()
            } else {
                binding.loadingView.hide()
            }
        })
    }

    private fun initData() {
        charactersViewModel.getData()
        binding.listCharacters.layoutManager = LinearLayoutManager(context)
        binding.listCharacters.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}