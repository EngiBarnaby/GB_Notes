package com.example.gb_notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(var notes : List<Note>, val listener : Listener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.note_title)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note = notes[position]
        holder.title.text = note.title
        holder.itemView.setOnClickListener{
            listener.onClick(note)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    interface Listener {
        fun onClick(note : Note)
    }

}