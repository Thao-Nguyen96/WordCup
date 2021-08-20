package com.nxt.ltday17

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.nxt.ltday17.adapter.WorldPagerAdapter
import com.nxt.ltday17.fragment.MatchFragment
import com.nxt.ltday17.fragment.PlayerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val adapter = WorldPagerAdapter(supportFragmentManager)
        adapter.addFragment(MatchFragment(), "Lịch đấu")
        adapter.addFragment(PlayerFragment(), "Cầu thủ")
        viewPager.adapter = adapter
        tab_layout.setupWithViewPager(viewPager)

        img_menu.setOnClickListener(this)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onClick(v: View?) {
        if (drawer_main.isDrawerOpen(GravityCompat.START)) {
            drawer_main.closeDrawer(GravityCompat.START)
        } else {
            drawer_main.openDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_lich_dau -> {
                viewPager.currentItem = 0
                drawer_main.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_cau_thu -> {
                viewPager.currentItem = 1
                drawer_main.closeDrawer(GravityCompat.START)
                return true
            }
            R.id.nav_about -> {
                Toast.makeText(this, "Android Developer", Toast.LENGTH_SHORT).show()
                drawer_main.closeDrawer(GravityCompat.START)
                return true
            }
        }
        return false
    }


}