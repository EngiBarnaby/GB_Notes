package com.example.gb_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class GreetingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn : Button = view.findViewById(R.id.next_screen)
        val fragmentManager = requireActivity().supportFragmentManager
        btn.setOnClickListener {
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, NotesFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}