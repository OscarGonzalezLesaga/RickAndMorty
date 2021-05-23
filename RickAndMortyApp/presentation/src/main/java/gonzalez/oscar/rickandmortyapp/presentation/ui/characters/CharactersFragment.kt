package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import gonzalez.oscar.domain.CartoonCharacter
import gonzalez.oscar.rickandmortyapp.R
import gonzalez.oscar.rickandmortyapp.databinding.CharacterViewBinding
import gonzalez.oscar.rickandmortyapp.databinding.FragmentCharactersBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.detailcharacter.DetailCharacterActivity
import gonzalez.oscar.rickandmortyapp.presentation.ui.detailcharacter.DetailCharacterActivity.Companion.CHARACTER_EXTRA
import gonzalez.oscar.rickandmortyapp.presentation.utils.hide
import gonzalez.oscar.rickandmortyapp.presentation.utils.show
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        lifecycleScope.launch {
            charactersViewModel.characters.collectLatest {
                adapter.submitData(it)
            }
        }
        /*charactersViewModel.dataCharacters.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessViewModel -> adapter.submitList(it.data)
                is ErrorViewModel -> toast(getString(R.string.error_load_characters))
            }

        })*/
    }

    private fun initData() {
        binding.listCharacters.layoutManager = LinearLayoutManager(context)
        adapter.itemClickListener = (::goToDetailCharacter)
        binding.listCharacters.adapter = adapter
    }

    private fun goToDetailCharacter(cartoonCharacter: CartoonCharacter, view: CharacterViewBinding) {
        val detailIntent = Intent(context, DetailCharacterActivity::class.java)
        val imageViewPair = Pair.create<View, String>(view.imageCharacter, getString(R.string.character_image_transition))
        val textViewPair = Pair.create<View, String>(view.nameCharacter, getString(R.string.name_character_transition))
        val options =
            ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), imageViewPair, textViewPair)

        detailIntent.putExtra(CHARACTER_EXTRA, cartoonCharacter) // pass your bundle data
        startActivity(detailIntent, options.toBundle())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}