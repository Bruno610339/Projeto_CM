package ipvc.estg.problemscityapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.problemscityapp.adapter.LineAdapter
import ipvc.estg.problemscityapp.dataclasses.Notes
import ipvc.estg.problemscityapp.entities.Note
import ipvc.estg.problemscityapp.viewModel.NoteViewModel
import kotlinx.android.synthetic.main.notes.*

class NotesActivity: AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private val addNoteActivityRequestCode = 1

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
            startActivityForResult(intent, addNoteActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addNoteActivityRequestCode && resultCode == Activity.RESULT_OK) {

            val titleVar = data?.getStringExtra(AddNoteActivity.EXTRA_REPLY_TITLE)
            val descVar = data?.getStringExtra(AddNoteActivity.EXTRA_REPLY_DESC)

            if(titleVar != null && descVar != null) {
                val note = Note(title = titleVar, description = descVar, date = "31-03-2021")
                noteViewModel.insert(note)
            }
        } else {
            Toast.makeText(applicationContext, "Not insert", Toast.LENGTH_LONG).show()
        }
    }
}