package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import gonzalez.oscar.rickandmortyapp.BaseViewModulesTest
import junit.framework.TestCase
import org.junit.*

class CharactersViewModelTest : BaseViewModulesTest() {

    lateinit var viewModule: CharactersViewModel

    @Before
    fun setUp() {
        viewModule = CharactersViewModel()
    }

    @Test
    fun `Verify that text is correct in Characters`() {
        TestCase.assertEquals(viewModule.text.value, "This is characters Fragment")
    }
}