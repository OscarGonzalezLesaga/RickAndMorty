package gonzalez.oscar.rickandmortyapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import gonzalez.oscar.rickandmortyapp.R.id
import gonzalez.oscar.rickandmortyapp.R.layout
import kotlinx.android.synthetic.main.activity_main.nav_view

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val navController = findNavController(id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                id.navigation_characters, id.navigation_episodes, id.navigation_locations
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }
}