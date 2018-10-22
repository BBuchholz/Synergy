package com.nineworldsdeep.synergy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import com.nineworldsdeep.synergy.ui.synergy.SynergyFragment

class SynergyActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.synergy_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame, SynergyFragment.newInstance())
                    .commitNow()
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->

            // set item as selected to persist highlight
            menuItem.isChecked = true

            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // add code here to update UI, such as swapping fragments
            // on selection

            true
        }
    }

}
