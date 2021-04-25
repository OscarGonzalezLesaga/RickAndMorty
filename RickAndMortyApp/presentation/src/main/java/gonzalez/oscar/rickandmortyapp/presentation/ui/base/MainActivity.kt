package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import gonzalez.oscar.rickandmortyapp.R.id
import gonzalez.oscar.rickandmortyapp.databinding.ActivityMainBinding
import gonzalez.oscar.rickandmortyapp.presentation.ui.characters.CharactersFragment
import gonzalez.oscar.rickandmortyapp.presentation.ui.episodes.EpisodesFragment
import gonzalez.oscar.rickandmortyapp.presentation.ui.locations.LocationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fragmentCharacters: CharactersFragment
    private val fragmentEpisodes = EpisodesFragment()
    private val fragmentLocation = LocationsFragment()
    private lateinit var fragmentActive: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initListeners()
    }

    private fun initView() {
        fragmentCharacters =
            supportFragmentManager.findFragmentById(id.nav_host_fragment)?.childFragmentManager?.fragments?.get(0) as CharactersFragment
        fragmentActive = fragmentCharacters

        with(supportFragmentManager.beginTransaction()) {
            add(id.nav_host_fragment, fragmentLocation).hide(fragmentLocation)
            add(id.nav_host_fragment, fragmentEpisodes).hide(fragmentEpisodes)
            add(id.nav_host_fragment, fragmentCharacters)
            commit()
        }
    }

    private fun initListeners() {
        binding.navView.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                id.navigation_characters -> {
                    supportFragmentManager.beginTransaction().hide(fragmentActive).show(fragmentCharacters).commit()
                    fragmentActive = fragmentCharacters
                    true
                }
                id.navigation_episodes -> {
                    supportFragmentManager.beginTransaction().hide(fragmentActive).show(fragmentEpisodes).commit()
                    fragmentActive = fragmentEpisodes
                    true
                }
                id.navigation_locations -> {
                    supportFragmentManager.beginTransaction().hide(fragmentActive).show(fragmentLocation).commit()
                    fragmentActive = fragmentLocation
                    true
                }
                else -> false
            }
        }
    }
}