package gonzalez.oscar.data

import gonzalez.oscar.network.ResourceData
import gonzalez.oscar.network.ResourceData.Success
import gonzalez.oscar.network.ServiceErrorDTO.UNKNOWN
import gonzalez.oscar.network.characters.CharactersDTO
import gonzalez.oscar.network.characters.CharactersNetwork
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.*

class CharactersRepositoryImplTest {

    private lateinit var repository: CharactersRepositoryImpl
    private lateinit var network: CharactersNetwork

    @Before
    fun setUp() {
        network = mockk()
        repository = CharactersRepositoryImpl(network)
    }

    @Test
    fun `Verify return correct list of Character from server`() {
        val resultServer: List<CharactersDTO> = FakeCharactersDTO.getListOfFakeCharacters(2)
        coEvery { network.getAllCharacters() } returns Success(resultServer)
        runBlocking {
            with(repository.getAllCharacters()!!) {
                assert(this.size == resultServer.size)
                val result = this.zip(resultServer)
                result.forEach { (result, resultMock) ->
                    assert(result.name == resultMock.name)
                    assert(result.image == resultMock.image)
                    assert(result.url == resultMock.url)
                }
            }
        }
    }

    @Test
    fun `Verify return null when server return error`() {
        coEvery { network.getAllCharacters() } returns ResourceData.Error(UNKNOWN)
        runBlocking {
            val result = repository.getAllCharacters()
            assertEquals(result, null)
        }
    }
}