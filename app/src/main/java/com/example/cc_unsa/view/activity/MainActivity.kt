package com.example.cc_unsa.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Space
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cc_unsa.R
import com.example.cc_unsa.viewmodel.DatabaseInitViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var databaseInitViewModel: DatabaseInitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Inicializar la base de datos
        databaseInitViewModel = ViewModelProvider(this)[DatabaseInitViewModel::class.java]
        lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    //Read data from file csv, and insert into database as ArtistEntity
                    databaseInitViewModel.insertArtistsFromCSV(this@MainActivity, "artists.csv")
                    databaseInitViewModel.insertGalleriesFromCSV(this@MainActivity, "galleries.csv")
                    databaseInitViewModel.insertExhibitionsFromCSV(this@MainActivity, "exhibitions.csv")
                    databaseInitViewModel.insertWorksFromCSV(this@MainActivity, "works.csv")
                }
        }


        startActivity(Intent(this, HomeActivity::class.java));

    }
}