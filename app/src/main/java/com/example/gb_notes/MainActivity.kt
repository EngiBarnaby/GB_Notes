package com.example.gb_notes

import android.content.DialogInterface
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog

import com.google.android.material.navigation.NavigationView








class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar();

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about -> ShowAboutFragment()
            R.id.action_exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun ShowAboutFragment() {
        val fragments  = supportFragmentManager.getFragments()
        var isAboutShow = false
        for (fragment in fragments){
            if(fragment is AboutFragment && fragment.isVisible()){
                isAboutShow = true
            }
        }
        if(!isAboutShow){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, AboutFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        initDrawer(toolbar);
    }

    private fun initDrawer(toolbar: Toolbar) {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.action_drawer_about -> {
                    ShowAboutFragment()
                    drawer.close()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_drawer_exit -> {

                    AlertDialog
                        .Builder(this)
                        .setTitle("Вы действительно хотите выйте?")
                        .setPositiveButton("Да", DialogInterface.OnClickListener{
                            dialog, id ->
                            Toast.makeText(this, "До новых встреч", Toast.LENGTH_SHORT).show();
                            finish()
                        })
                        .setNegativeButton("Нет", DialogInterface.OnClickListener {
                                dialog, id ->
                                Toast.makeText(this, "Мы рады, что вы решили остаться", Toast.LENGTH_SHORT).show();
                                dialog.cancel()
                        })
                        .show()

                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }


}