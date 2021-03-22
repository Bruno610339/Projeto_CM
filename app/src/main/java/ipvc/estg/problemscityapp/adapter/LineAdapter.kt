package ipvc.estg.problemscityapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.problemscityapp.R
import ipvc.estg.problemscityapp.dataclasses.Notes
import kotlinx.android.synthetic.main.recycler_notes_line.view.*

class LineAdapter(private val list: ArrayList<Notes>): RecyclerView.Adapter<LineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_notes_line, parent, false)

        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val currentNote = list[position]

        holder.title.text = currentNote.title
        holder.description.text = currentNote.description
    }
}

class LineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.title_content
    val description: TextView = itemView.description_content
}