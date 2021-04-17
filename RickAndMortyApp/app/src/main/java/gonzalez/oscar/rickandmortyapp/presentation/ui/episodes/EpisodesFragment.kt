package gonzalez.oscar.rickandmortyapp.presentation.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import gonzalez.oscar.rickandmortyapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : Fragment() {

    private val mEpisodesViewModel: EpisodesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_episodes, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        mEpisodesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}