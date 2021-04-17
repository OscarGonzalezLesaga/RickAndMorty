package gonzalez.oscar.rickandmortyapp.presentation.ui.locations

import gonzalez.oscar.rickandmortyapp.BaseViewModulesTest
import junit.framework.TestCase
import org.junit.*

class LocationsViewModelTest : BaseViewModulesTest() {

    lateinit var viewModule: LocationsViewModel

    @Before
    fun setUp() {
        viewModule = LocationsViewModel()
    }

    @Test
    fun `Verify that text is correct in Locations`() {
        TestCase.assertEquals(viewModule.text.value, "This is locations Fragment")
    }
}