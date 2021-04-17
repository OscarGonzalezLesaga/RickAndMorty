package gonzalez.oscar.rickandmortyapp.presentation.ui.base

import android.app.Application
import gonzalez.oscar.rickandmortyapp.di.modulesRickAndMorty
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(modulesRickAndMorty)
        }
    }
}