package com.arondillqs5328.magicv20.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.ui.fragment.advertising.AdvertisingFragment
import com.arondillqs5328.magicv20.ui.fragment.cryptocurrency.CryptocurrencyFragment
import com.arondillqs5328.magicv20.ui.fragment.favotite.FavoriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView
    private var fragments: HashMap<Int, Fragment> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavView()

        savedInstanceState ?: replaceFragment(R.id.cryptocurrency)
    }

    private fun setupBottomNavView() {
        bottomNavView = findViewById(R.id.main_bottom_nav_view)
        bottomNavView.selectedItemId = R.id.cryptocurrency
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.favorite -> replaceFragment(R.id.favorite)
                R.id.cryptocurrency -> replaceFragment(R.id.cryptocurrency)
                R.id.advertising -> replaceFragment(R.id.advertising)

                else -> true
            }
        }
    }

    private fun replaceFragment(id: Int): Boolean {
        fun getFragment(id: Int): Fragment {
            when (id) {
                R.id.favorite -> return FavoriteFragment()
                R.id.cryptocurrency -> return CryptocurrencyFragment()
                R.id.advertising -> return AdvertisingFragment()
            }
            return Fragment()
        }

        if (fragments.contains(id)) {
            fragments[id]?.let {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame_layout, it)
                    .commit()
            }
        } else {
            val fragment: Fragment = getFragment(id)
            fragments[id] = fragment
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame_layout, fragment)
                .commit()
        }
        return true
    }
}
