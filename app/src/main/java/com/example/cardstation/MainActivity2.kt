package com.example.cardstation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import settingsFragment

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val home = HomeFragment()
        val search : Fragment= SearchFragment()
        val cart: Fragment = cartFragment()
        val settings : Fragment = settingsFragment()

        val bottomNav = findViewById<BottomNavigationView>(R.id.b1)
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment, home)
            .commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(home)
                R.id.search -> replaceFragment(search)
                R.id.basket -> replaceFragment(cart)
                R.id.settings -> replaceFragment(settings)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment, fragment)
            .commit()
    }
}

