package com.example.gb_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView




class NoteContentFragment : Fragment() {

    val ARG_INDEX = "index"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_content, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments
        val inputData = args?.get("content")
        val stringArray = getResources().getStringArray(R.array.noteContent)
        val content = stringArray[inputData as Int]
        val tv : TextView = view.findViewById(R.id.contentTV)
        tv.text = content.toString()
    }



    companion object {


        fun newInstance(index: Int): NoteContentFragment? {
            val fragment = NoteContentFragment()
            val args = Bundle()
            args.putInt("content", index)
            fragment.setArguments(args)
            return fragment
        }
    }

}