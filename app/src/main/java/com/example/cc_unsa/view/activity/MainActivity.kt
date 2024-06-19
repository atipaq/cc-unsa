package com.example.cc_unsa.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cc_unsa.R
import com.example.cc_unsa.databinding.ActivityMainBinding
import com.example.cc_unsa.view.fragment.ArtistsFragment
import com.example.cc_unsa.view.fragment.CategoriesFragment
import com.example.cc_unsa.view.fragment.HomeFragment
import com.example.cc_unsa.view.fragment.InformationFragment
import com.example.cc_unsa.view.fragment.MapFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.background = null

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.categories -> replaceFragment(CategoriesFragment())
                R.id.artists -> replaceFragment(ArtistsFragment())
                R.id.information -> replaceFragment(InformationFragment())
            }
            true
        }

        binding.maps.setOnClickListener {
            replaceFragment(MapFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
