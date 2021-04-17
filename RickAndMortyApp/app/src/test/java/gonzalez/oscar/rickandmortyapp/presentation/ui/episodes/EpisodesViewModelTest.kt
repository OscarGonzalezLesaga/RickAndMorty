package gonzalez.oscar.rickandmortyapp.presentation.ui.episodes

import gonzalez.oscar.rickandmortyapp.BaseViewModulesTest
import junit.framework.TestCase
import org.junit.*

class EpisodesViewModelTest : BaseViewModulesTest() {

    lateinit var viewModule: EpisodesViewModel

    @Before
    fun setUp() {
        viewModule = EpisodesViewModel()
    }

    @Test
    fun `Verify that text is correct in Episodes`() {
        TestCase.assertEquals(viewModule.text.value, "This is episodes Fragment")
    }
}