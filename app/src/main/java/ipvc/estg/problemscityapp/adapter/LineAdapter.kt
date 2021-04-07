package ipvc.estg.problemscityapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.problemscityapp.R
import ipvc.estg.problemscityapp.dataclasses.Notes
import ipvc.estg.problemscityapp.entities.Note
import kotlinx.android.synthetic.main.recycler_notes_line.view.*
import org.w3c.dom.Text
import java.util.*

class LineAdapter internal constructor(context: Context): RecyclerView.Adapter<LineAdapter.NoteViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notes = emptyList<Note>()

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val noteDate: TextView = itemView.findViewById(R.id.date_content)
        val noteTitle: TextView = itemView.findViewById(R.id.title_content)
        val noteDescription: TextView = itemView.findViewById(R.id.description_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_notes_line, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = notes[position]
        holder.noteDate.text = current.date
        holder.noteTitle.text = current.title
        holder.noteDescription.text = current.description
    }

    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount() = notes.size
}