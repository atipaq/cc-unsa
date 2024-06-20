package com.example.painting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.painting.databinding.ActivityPaintingDetailsBinding

class PaintingDetails : AppCompatActivity() {
    var binding:ActivityPaintingDetailsBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPaintingDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding?.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }

        // creating an employee list
        // of type Employee class
        var emplist:PaintDetail?=null

        // checking if the intent has extra
        if(intent.hasExtra(MainActivity.NEXT_SCREEN)){
            // get the Serializable data model class with the details in it
            emplist = intent.getParcelableExtra<PaintDetail>(MainActivity.NEXT_SCREEN)
        }
        // it the emplist is not null the it has some data and display it
        if(emplist!=null){
            //binding?.displayImage?.
            binding?.displayImage?.setImageResource(emplist!!.imageId[0]) // displaying image
            //binding?.displayName?.text=emplist!!.name   // displaying name
            //binding?.displayEmail?.text=emplist!!.email // displaying email
        }

    }
}
