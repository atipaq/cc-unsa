package com.example.cc_unsa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.cc_unsa.R
import com.example.cc_unsa.view.customview.MainSketchView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class MainMapFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_main_map, container, false)

        //mostrar MainSketchView en frameLayout
        val mapa = MainSketchView(this.context)
        val frameLayout = view.findViewById<FrameLayout>(R.id.mainMapContainer)
        frameLayout.addView(mapa)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainMapFragment().apply {


            }
    }
}