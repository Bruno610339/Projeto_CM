package ipvc.estg.problemscityapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "note_table")

class Note(
        @PrimaryKey(autoGenerate = true) val id: Int? = null,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "date") val date: String
)
