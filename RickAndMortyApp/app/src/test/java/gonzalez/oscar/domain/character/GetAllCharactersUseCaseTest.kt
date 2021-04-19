package gonzalez.oscar.domain.character

import gonzalez.oscar.domain.CartoonCharacter
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.*

class GetAllCharactersUseCaseTest {

    private lateinit var useCase: GetAllCharactersUseCase
    private lateinit var repository: CharactersRepository

    @Before
    fun setUp() {
        repository = mockk(relaxed = true)
        useCase = GetAllCharactersUseCase(repository)
    }

    @Test
    fun `Verify that repository is called when invoke getAllCharacter use case`() {
        val resultMock: List<CartoonCharacter> = mockk()
        coEvery { repository.getAllCharacters() } returns resultMock
        runBlocking {
            val result = useCase.invoke()
            coVerify {
                repository.getAllCharacters()
            }
            assertEquals(result, resultMock)
        }
    }
}