package gonzalez.oscar.local.characters

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharactersDao {

    @Query("SELECT * FROM CharactersDob")
    fun getAll(): List<CharactersDob>

    @Insert
    fun insertAll(vararg charactersDob: CharactersDob)

    @Delete
    fun delete(charactersDob: CharactersDob)
}