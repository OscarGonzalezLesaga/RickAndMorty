package gonzalez.oscar.network.characters

import gonzalez.oscar.network.ResourceData
import gonzalez.oscar.network.ResourceData.Success
import gonzalez.oscar.network.ServiceErrorDTO.CONNECTION
import gonzalez.oscar.network.ServiceErrorDTO.UNKNOWN
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.*
import java.net.UnknownHostException

class CharactersNetworkTest {

    private lateinit var network: CharactersNetwork
    private lateinit var api: CharactersApi

    @Before
    fun setUp() {
        api = mockk()
        network = CharactersNetwork()
        network.service = api
    }

    @Test
    fun `Verify network return success with data when server return correct data`() {
        val listCharactersMock: List<CharactersDTO> = mockk()
        val resultServer: AllCharactersDTO = mockk {
            every { listCharacters } returns listCharactersMock
        }

        coEvery { api.getAllCharacters(1) } returns resultServer
        runBlocking {
            val result = network.getAllCharacters(1)
            assert(result is Success)
            assertEquals(result.data, listCharactersMock)
        }
    }

    @Test
    fun `Verify network return error connection with data when server return error unknown host`() {
        coEvery { api.getAllCharacters(1) } throws UnknownHostException()
        runBlocking {
            val result = network.getAllCharacters(1)
            assert(result is ResourceData.Error)
            assert(result.error == CONNECTION)
        }
    }

    @Test
    fun `Verify network return error unknown with data when server return unexpected error`() {
        coEvery { api.getAllCharacters(1) } throws Exception()
        runBlocking {
            val result = network.getAllCharacters(1)
            assert(result is ResourceData.Error)
            assert(result.error == UNKNOWN)
        }
    }
}