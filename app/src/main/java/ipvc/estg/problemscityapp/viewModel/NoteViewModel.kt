package ipvc.estg.problemscityapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ipvc.estg.problemscityapp.db.NoteDB
import ipvc.estg.problemscityapp.db.NoteRepository
import ipvc.estg.problemscityapp.entities.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val notesDao = NoteDB.getDatabase(application, viewModelScope).noteDao()
        repository = NoteRepository(notesDao)
        allNotes = repository.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

    fun edit(title: String, description: String, date: String, id: Int?) = viewModelScope.launch {
        repository.updateNote(title, description, date, id)
    }

    fun deleteById(id: Int?) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteByID(id)
    }
}