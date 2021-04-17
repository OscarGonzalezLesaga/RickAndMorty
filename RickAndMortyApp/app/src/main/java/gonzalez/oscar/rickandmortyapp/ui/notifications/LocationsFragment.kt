package gonzalez.oscar.rickandmortyapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import gonzalez.oscar.rickandmortyapp.R

class LocationsFragment : Fragment() {

    private lateinit var mLocationsViewModel: LocationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mLocationsViewModel =
            ViewModelProvider(this).get(LocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_locations, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        mLocationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}