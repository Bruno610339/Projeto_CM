package ipvc.estg.problemscityapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ipvc.estg.problemscityapp.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()

    @Query("DELETE FROM note_table WHERE id = :id")
    fun deleteById(id: Int?)

    @Update
    suspend fun updateNote(note: Note)
}