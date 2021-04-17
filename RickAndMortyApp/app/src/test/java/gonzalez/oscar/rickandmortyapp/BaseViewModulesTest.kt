package gonzalez.oscar.rickandmortyapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.*

open class BaseViewModulesTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
}