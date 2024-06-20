package com.example.cc_unsa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cc_unsa.R
import com.example.cc_unsa.view.customview.CustomMapView

class MapFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Crea una instancia de BuildingPlanView y devuélvela como la vista del fragmento
        return CustomMapView(requireContext())
    }
}
