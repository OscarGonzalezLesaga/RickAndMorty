package gonzalez.oscar.rickandmortyapp.presentation.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import gonzalez.oscar.domain.Episode
import gonzalez.oscar.rickandmortyapp.databinding.EpisodeViewBinding
import gonzalez.oscar.rickandmortyapp.databinding.FragmentEpisodesBinding
import gonzalez.oscar.rickandmortyapp.presentation.utils.toast
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : Fragment() {

    private val episodesViewModel: EpisodesViewModel by viewModel()
    private var _binding: FragmentEpisodesBinding? = null
    private val binding get() = _binding!!
    private val adapter = EpisodesViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        binding.listEpisodes.layoutManager = LinearLayoutManager(context)
        adapter.itemClickListener = (::goToDetailEpisode)
        binding.listEpisodes.adapter = adapter
    }

    private fun goToDetailEpisode(episode: Episode, episodeViewBinding: EpisodeViewBinding) {
        toast("To Do")
    }

    private fun initObservers() {
        lifecycleScope.launch {
            episodesViewModel.episodes.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}