package gonzalez.oscar.local

import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import gonzalez.oscar.local.characters.CharactersDao
import gonzalez.oscar.local.characters.CharactersDob

@Database(entities = [CharactersDob::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharactersDao


}