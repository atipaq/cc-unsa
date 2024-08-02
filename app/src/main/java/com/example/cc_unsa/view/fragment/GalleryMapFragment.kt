package com.example.cc_unsa.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cc_unsa.R
import com.example.cc_unsa.view.customview.GalleryMapView
import com.example.cc_unsa.viewmodel.GalleryInfoViewModel
import com.example.cc_unsa.viewmodel.dto.ExhibitionDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionInfoInMapDto
import com.example.cc_unsa.viewmodel.dto.GalleryDto
import com.example.cc_unsa.viewmodel.dto.WorkDto
import com.example.cc_unsa.viewmodel.dto.WorkInGalleryDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GalleryMapFragment : Fragment() {
    private var galleryId: Int? = null
    private lateinit var galleryInfo: ExhibitionInfoInMapDto
    private lateinit var works: List<WorkInGalleryDto>
    private val months = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            galleryId = it.getInt("galleryId")
        }
        //Obtener informacion de la galeria from View Model
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                val galleryInfoViewModel = GalleryInfoViewModel(requireActivity().application)
                galleryInfo = galleryInfoViewModel.getExhibitionById(galleryId!!)
                works = galleryInfoViewModel.getWorksByExhibitionId(galleryId!!)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery_map, container, false)

        //Set gallery info
        view.findViewById<TextView>(R.id.txtTitleGalleryMap).text = galleryInfo.name
        view.findViewById<TextView>(R.id.txtDescriptionGalleryMap).text = galleryInfo.descriptionText
        view.findViewById<TextView>(R.id.txtLocationGalleryMap).text = galleryInfo.galleryName
        view.findViewById<TextView>(R.id.txtArtistGalleryMap).text = galleryInfo.artistName
        view.findViewById<TextView>(R.id.txtPeriodGalleryMap).text = months[galleryInfo.period - 1]

        //Mostrar mapa
        val galleryMap = this.context?.let { GalleryMapView(it, galleryInfo.galleryName, works) }
        val frameLayout = view.findViewById<FrameLayout>(R.id.galleryMapContainer)
        galleryMap?.let { frameLayout.addView(it) }

        return view
    }

}