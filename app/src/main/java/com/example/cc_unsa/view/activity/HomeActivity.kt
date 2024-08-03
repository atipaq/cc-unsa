package com.example.cc_unsa.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import com.example.cc_unsa.R
import com.example.cc_unsa.databinding.ActivityHomeBinding
import com.example.cc_unsa.view.fragment.CarouselHomeFragment
import com.example.cc_unsa.view.fragment.FragmentListener
import com.example.cc_unsa.view.fragment.GalleryMapFragment
import com.example.cc_unsa.view.fragment.MainMapFragment
import com.example.cc_unsa.view.fragment.WorkDetailFragment

class HomeActivity : AppCompatActivity(), FragmentListener {

    private lateinit var binding: ActivityHomeBinding
    private var itemMenuSelected: Int = 1
    private val tittlesMenu = listOf("Artistas", "Pinturas", "Exposiciones")
    private lateinit var menuHome: List<View>
    private lateinit var tittleMenuHome: List<TextView>
    private lateinit var thisMotionLAyout:MotionLayout
    private var anyFragmentViewOnStack: Boolean = false
    private var onGalleryMapView: Boolean = false
    private var onWorkFragmentView: Boolean = false

    override fun replaceFragment(galleryId:Int) {
        anyFragmentViewOnStack = true
        onGalleryMapView = true
        val galleryFragment = GalleryMapFragment().apply {
            arguments = Bundle().apply {
                putInt("galleryId", galleryId)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainMapFragmentView, galleryFragment)
            .addToBackStack(null)  // Permite volver a MyFragment con el botón "atrás"
            .commit()
    }

    override fun replaceToWorkFragment(workId: Int) {
        anyFragmentViewOnStack = true
        onWorkFragmentView = true
        val workFragment = WorkDetailFragment().apply {
            arguments = Bundle().apply {
                putInt("workId", workId)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainMapFragmentView, workFragment)
            .addToBackStack(null)  // Permite volver a MyFragment con el botón "atrás"
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.main)
        thisMotionLAyout = binding.main

        //Lanzar fragmento de mapa
        binding.btnViwMapIcon.setOnClickListener {
            thisMotionLAyout.transitionToState(R.id.endMap)
            val fragment = MainMapFragment.newInstance()
            anyFragmentViewOnStack = true
            supportFragmentManager.beginTransaction().replace(R.id.mainMapFragmentView, fragment)
                .commit()
        }

        //Cerrar panel inferior al hacer click en el boton de atras
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.e("NumberFragment", supportFragmentManager.backStackEntryCount.toString())
                if(supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStackImmediate()
                } else {
                    setStartTransition()
                }
            }
        })
        binding.btnBackPanel.setOnClickListener {
            setStartTransition()
        }
        thisMotionLAyout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                if (p1 == R.id.start) {
                    if(supportFragmentManager.findFragmentById(R.id.mainMapFragmentView) != null) {
                        supportFragmentManager.beginTransaction()
                            .remove(supportFragmentManager.findFragmentById(R.id.mainMapFragmentView)!!)
                            .commit()
                        anyFragmentViewOnStack = false
                    }
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })
        //Menu
        menuHome = listOf(
            binding.itemMenuArtista,
            binding.itemMenuPintura,
            binding.itemMenuExposicion
        )
        tittleMenuHome = listOf(
            binding.titleMenuArtista,
            binding.tittleMenuPintura,
            binding.titleMenuExposicion
        )
        val carouselFragment = CarouselHomeFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.carouselFragmentContainerView, carouselFragment)
            .commit()

        for (item in menuHome){
            Log.e("item", item.toString())
            item.setOnClickListener {
                itemMenuSelected = menuHome.indexOf(item)
                updateTitleMenu()
                val carouselFragmentInstance = supportFragmentManager.findFragmentById(R.id.carouselFragmentContainerView) as CarouselHomeFragment
                carouselFragmentInstance.updateList(itemMenuSelected)
            }
        }

    }
    private fun setStartTransition(){
        if(thisMotionLAyout.currentState == thisMotionLAyout.endState) {
            thisMotionLAyout.transitionToStart()
        } else {
            finish()
        }
    }


    private fun updateTitleMenu() {
        val titlePanelBottom = binding.titleCategoryBottomPannel
        titlePanelBottom.text = tittlesMenu[itemMenuSelected]

        //change color from item.textview
        for (item in tittleMenuHome){
            if (tittleMenuHome.indexOf(item) == itemMenuSelected)
                item.setTextColor(ContextCompat.getColor(this, R.color.red_title))
            else
                item.setTextColor(resources.getColor(android.R.color.darker_gray, null))
        }
    }
}