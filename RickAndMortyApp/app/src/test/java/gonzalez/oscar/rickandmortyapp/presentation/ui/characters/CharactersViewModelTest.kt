package gonzalez.oscar.rickandmortyapp.presentation.ui.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import gonzalez.oscar.domain.character.CartoonCharacter
import gonzalez.oscar.domain.character.GetAllCharactersUseCase
import gonzalez.oscar.rickandmortyapp.CoroutinesTestRule
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.ErrorViewModel
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.StateCharacters
import gonzalez.oscar.rickandmortyapp.presentation.ui.base.SuccessViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*

@ExperimentalCoroutinesApi
class CharactersViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    @get:Rule
    val testInstantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModule: CharactersViewModel
    lateinit var useCaseAllCharacters: GetAllCharactersUseCase
    private lateinit var observerLoading: Observer<Boolean>
    private lateinit var observerData: Observer<StateCharacters>

    @Before
    fun setUp() {
        useCaseAllCharacters = mockk()
        observerLoading = mockk(relaxed = true)
        observerData = mockk(relaxed = true)
        viewModule = CharactersViewModel(useCaseAllCharacters, coroutineTestRule.dispatcher)
        viewModule.loading.observeForever(observerLoading)
        viewModule.dataCharacters.observeForever(observerData)
    }

    @After
    fun clean() {
        viewModule.loading.removeObserver(observerLoading)
        viewModule.dataCharacters.removeObserver(observerData)
    }

    @Test
    fun `Verify that data is load correctly from server`() = coroutineTestRule.runBlockingTest {
        val resultMovies: List<CartoonCharacter> = mockk {
            every { isEmpty() } returns false
        }
        coEvery { useCaseAllCharacters.invoke() } returns resultMovies
        viewModule.getData()
        coVerify {
            observerLoading.onChanged(true)
            useCaseAllCharacters.invoke()
            observerData.onChanged(SuccessViewModel(resultMovies))
            observerLoading.onChanged(false)
        }
    }

    @Test
    fun `Verify that return error when server return wrong data`() = coroutineTestRule.runBlockingTest {
        val resultMovies: List<CartoonCharacter> = mockk {
            every { isEmpty() } returns true
        }
        coEvery { useCaseAllCharacters.invoke() } returns resultMovies
        viewModule.getData()
        coVerify {
            observerLoading.onChanged(true)
            useCaseAllCharacters.invoke()
            observerData.onChanged(ErrorViewModel())
            observerLoading.onChanged(false)
        }
    }
}