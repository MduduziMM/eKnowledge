package com.elapsedevelopment.eknowledgeprojectassign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
     //   toolbar.title = "eKnowledge"


        val btnOne: Button = findViewById(R.id.button_one)
        val btnTwo: Button = findViewById(R.id.button_two)
        val btnThree: Button = findViewById(R.id.button_three)



        btnOne.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Activity1::class.java)
                startActivity(intent)

        })

        btnTwo.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Activity2::class.java)
            startActivity(intent)
        })

        btnThree.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Activity3::class.java)
            startActivity(intent)
        })

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "A Page Will Open...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "Clicked: Home", Toast.LENGTH_LONG).show()
            }
            R.id.nav_tips -> {
                Toast.makeText(this, "Clicked: Tips", Toast.LENGTH_LONG).show()
            }
            R.id.nav_portal -> {
                Toast.makeText(this, "Clicked: Portal", Toast.LENGTH_LONG).show()
            }
            R.id.nav_attendance -> {
                Toast.makeText(this, "Clicked: Attendance", Toast.LENGTH_LONG).show()
            }
            R.id.nav_textbooks -> {
                Toast.makeText(this, "Clicked: TextBooks", Toast.LENGTH_LONG).show()
            }
            R.id.nav_events -> {
                Toast.makeText(this, "Clicked: Events", Toast.LENGTH_LONG).show()
            }
            R.id.nav_share -> {
                Toast.makeText(this, "Clicked: Share", Toast.LENGTH_LONG).show()
            }
            R.id.nav_settings -> {
                Toast.makeText(this, "Clicked: Settings", Toast.LENGTH_LONG).show()
            }
            R.id.nav_tools -> {
                Toast.makeText(this, "Clicked: Tools", Toast.LENGTH_LONG).show()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}