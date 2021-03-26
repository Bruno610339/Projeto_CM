package ipvc.estg.problemscityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.problemscityapp.adapter.LineAdapter
import ipvc.estg.problemscityapp.dataclasses.Notes
import ipvc.estg.problemscityapp.viewModel.NoteViewModel
import kotlinx.android.synthetic.main.notes.*

class NotesActivity: AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    //private val addNoteActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = "Notes"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = LineAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes.observe(this, Observer { notes ->
            notes?.let { adapter.setNotes(it) }
        })

        //Add Note Button
        val addNote = findViewById<Button>(R.id.btn_add_note)
        addNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

    }
}