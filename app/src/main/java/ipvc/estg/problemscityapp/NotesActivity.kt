package ipvc.estg.problemscityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ipvc.estg.problemscityapp.adapter.LineAdapter
import ipvc.estg.problemscityapp.dataclasses.Notes
import kotlinx.android.synthetic.main.notes.*

class NotesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes)

        //Change the title of Activity on Bar
        val actionBar = supportActionBar
        actionBar!!.title = "Notes"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //RecyclerView
        val list = generateExample(10)

        recycler_view.adapter = LineAdapter(list)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    //Função para gerar linhas para a recyclerView
    private fun generateExample(size: Int): ArrayList<Notes> {
        val list = ArrayList<Notes>()

        for (i in 0 until size) {
            val item = Notes("$i", "Description")
            list += item
        }

        return list
    }
}