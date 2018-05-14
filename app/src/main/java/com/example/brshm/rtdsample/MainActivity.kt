package com.example.brshm.rtdsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // NOTE: You can remove this and reference the DrawerLayout directly
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mDrawerLayout = findViewById(R.id.drawer_layout)

//        val navigationView: NavigationView = findViewById(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener { menuItem ->
            // Deselect settings button
            settings_button.isSelected = false
            settings_button.setTextColor(ContextCompat.getColor(this, R.color.primary_text_default_material_light))

            // set item as selected to persist highlight
            menuItem.isChecked = true

            // close drawer when item is tapped
            drawer_layout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }

        settings_button.setOnClickListener {
            // Deselect other nav items
            val menu = nav_view.menu
            for (i in 0 until menu.size())
                menu.getItem(i).isChecked = false

            // Select settings button
            settings_button.isSelected = true
            settings_button.setTextColor(ContextCompat.getColor(this, R.color.colorMenuTextSelected))

            // Close drawer
            drawer_layout.closeDrawers()

            // Do any logic here
        }
    }

}
