package com.example.gb_notes

import android.content.res.Configuration
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import android.widget.TextView


import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NotesFragment : Fragment(), NoteAdapter.Listener {

    var notes = mutableListOf<Note>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv : RecyclerView = view.findViewById(R.id.recycle_notes)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = NoteAdapter(initData(), this)

    }

    private fun initData() : List<Note>{
        for(item in 1..5){
            val note = Note(title = "Заметка №$item", content = "Содержание заметки №$item")
            notes.add(note)
        }
        return notes
    }


    private fun showNotes(noteContent: String) {
            showPortraitContent(noteContent)
    }


    private fun showPortraitContent(noteContent: String) {
        val noteContentFragment: NoteContentFragment? = NoteContentFragment.newInstance(noteContent)
        val fragmentManager = requireActivity().supportFragmentManager
        if (noteContentFragment != null) {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, noteContentFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }

    override fun onClick(note: Note) {
        showNotes(note.content)
    }

}