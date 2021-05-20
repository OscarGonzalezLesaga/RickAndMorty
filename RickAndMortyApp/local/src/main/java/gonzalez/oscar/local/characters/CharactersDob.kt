package gonzalez.oscar.local.characters

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharactersDob(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "image") val image: String
)


