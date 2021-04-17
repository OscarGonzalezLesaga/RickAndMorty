package gonzalez.oscar.rickandmortyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import gonzalez.oscar.rickandmortyapp.R

class CharactersFragment : Fragment() {

    private lateinit var mCharactersViewModel: CharactersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mCharactersViewModel =
            ViewModelProvider(this).get(CharactersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_characters, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        mCharactersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}