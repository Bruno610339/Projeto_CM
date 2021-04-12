package ipvc.estg.problemscityapp.db

import androidx.lifecycle.LiveData
import ipvc.estg.problemscityapp.dao.NoteDao
import ipvc.estg.problemscityapp.entities.Note
import java.util.*

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun updateNote(title: String, description: String, date: String, id: Int?) {
        noteDao.updateNote(title, description, date, id)
    }

    fun deleteByID(id: Int?) {
        noteDao.deleteById(id)
    }
}