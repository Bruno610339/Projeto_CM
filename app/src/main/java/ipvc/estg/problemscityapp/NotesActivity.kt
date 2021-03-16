package ipvc.estg.problemscityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = "Notes"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}