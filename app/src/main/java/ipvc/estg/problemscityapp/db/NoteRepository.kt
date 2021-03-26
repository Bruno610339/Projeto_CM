package ipvc.estg.problemscityapp.db

import androidx.lifecycle.LiveData
import ipvc.estg.problemscityapp.dao.NoteDao
import ipvc.estg.problemscityapp.entities.Note

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}