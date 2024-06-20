package com.example.painting

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.painting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null
    private lateinit var viewPager2 : ViewPager2
    private lateinit var haldler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter : ImageAdapterViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        init()
        setUpTransformer()

        val emplist=PaintsList.getPaintsList()

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.rvItemsList?.layoutManager = staggeredGridLayoutManager
        binding?.rvItemsList?.setHasFixedSize(true)

        val ItemAdapter = ItemAdapter(emplist)

        binding?.rvItemsList?.adapter = ItemAdapter

        ItemAdapter.setOnClickListener(object :
            ItemAdapter.OnClickListener {
            override fun onClick(position: Int, model: PaintDetail) {
                val intent = Intent(this@MainActivity, PaintingDetails::class.java)
                intent.putExtra(NEXT_SCREEN, model)
                startActivity(intent)
            }
        })
    }
    companion object{
        val NEXT_SCREEN="details_screen"
    }
    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(transformer)

    }
    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        haldler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()
        imageList.add(R.drawable.ccunsaimage1)
        imageList.add(R.drawable.ccunsaimage2)
        imageList.add(R.drawable.ccunsaimage3)
        imageList.add(R.drawable.ccunsaimage4)
        imageList.add(R.drawable.ccunsaimage5)
        imageList.add(R.drawable.ccunsaimage6)
        imageList.add(R.drawable.ccunsaimage7)
        imageList.add(R.drawable.ccunsaimage8)

        adapter = ImageAdapterViewPager(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}