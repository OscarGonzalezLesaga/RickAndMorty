package gonzalez.oscar.rickandmortyapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import gonzalez.oscar.rickandmortyapp.R

class EpisodesFragment : Fragment() {

    private lateinit var mEpisodesViewModel: EpisodesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mEpisodesViewModel =
            ViewModelProvider(this).get(EpisodesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_episodes, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        mEpisodesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}