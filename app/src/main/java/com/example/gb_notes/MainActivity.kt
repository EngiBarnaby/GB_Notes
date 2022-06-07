package com.example.gb_notes

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, GreetingFragment())
            .commit()
//
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, NotesFragment())
//            .commit()

//        if (getResources().configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            val content : NoteContentFragment? = NoteContentFragment.newInstance(0)
//            if (content != null) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.note_content, content)
//                    .commit()
//            }
//        }
    }
}