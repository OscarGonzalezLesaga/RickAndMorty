package gonzalez.oscar.rickandmortyapp.presentation.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import gonzalez.oscar.domain.LocationUniverse
import gonzalez.oscar.rickandmortyapp.databinding.FragmentLocationsBinding
import gonzalez.oscar.rickandmortyapp.databinding.LocationViewBinding
import gonzalez.oscar.rickandmortyapp.presentation.utils.toast
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : Fragment() {

    private val locationViewHolder: LocationsViewModel by viewModel()
    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!
    private val adapter = LocationsViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        binding.listLocations.layoutManager = LinearLayoutManager(context)
        adapter.itemClickListener = (::goToDetailLocation)
        binding.listLocations.adapter = adapter
    }

    private fun goToDetailLocation(locationUniverse: LocationUniverse, locationViewBinding: LocationViewBinding) {
        toast("To Do")
    }

    private fun initObservers() {
        lifecycleScope.launch {
            locationViewHolder.locations.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}