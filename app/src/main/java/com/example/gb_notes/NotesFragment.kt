package com.example.gb_notes

import android.content.res.Configuration
import android.os.Bundle
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





class NotesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList(view)
    }

    private fun initList(view : View){
        val layoutView = view as LinearLayout
        val notes = resources.getStringArray(R.array.noteNames)
        var index = 0
        for (note in notes) {
            val tv = TextView(context)
            tv.text = note
            tv.textSize = 30f
            layoutView.addView(tv)
            val position = index
            tv.setOnClickListener{
                showNotes(position)
            }
            index++
        }
    }

    private fun showNotes(position: Int) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLandContent(position)
        } else {
            showPortraitContent(position)
        }
    }

    private fun showLandContent(position: Int) {
        val noteContentFragment: NoteContentFragment? = NoteContentFragment.newInstance(position)
        val fragmentManager = requireActivity().supportFragmentManager
        if (noteContentFragment != null) {
            fragmentManager.beginTransaction()
                .replace(R.id.note_content, noteContentFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }

    private fun showPortraitContent(position: Int) {
        val noteContentFragment: NoteContentFragment? = NoteContentFragment.newInstance(position)
        val fragmentManager = requireActivity().supportFragmentManager
        if (noteContentFragment != null) {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, noteContentFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }

//
//    private fun showNoteContent(position: Int) {
//        val stringArray = getResources().getStringArray(R.array.noteContent)
//        val content = stringArray[position]
//        val bundle = Bundle()
//        bundle.putString("content", content)
//        val fragment = NoteContentFragment()
//        fragment.arguments = bundle
//        fragmentManager?.beginTransaction()
//            ?.addToBackStack(null)
//            ?.replace(R.id.fragment_container, fragment)
//            ?.commit()
//
//    }


}