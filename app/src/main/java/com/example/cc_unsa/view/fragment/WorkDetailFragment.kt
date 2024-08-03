package com.example.cc_unsa.view.fragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.hoko.blur.HokoBlur
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.cc_unsa.R
import com.example.cc_unsa.model.entity.WorkEntity
import com.example.cc_unsa.viewmodel.GalleryInfoViewModel
import com.example.cc_unsa.viewmodel.WorkInfoViewModel
import com.example.cc_unsa.viewmodel.dto.WorkDto
import com.example.cc_unsa.viewmodel.dto.WorkInGalleryDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "workId"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var workId: Int? = null
    private lateinit var work: WorkEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            workId = it.getInt(ARG_PARAM1)
        }

        //Obtener informacion de la obra from View Model
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                val workInfoViewModelViewModel = WorkInfoViewModel(requireActivity().application)
                work = workInfoViewModelViewModel.getWorkById(workId!!)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_work_detail, container, false)

        // Inflate the layout for this fragment
        try {
            val imageFile = "pinturas/"+work.image
            val inputStream = context?.assets?.open(imageFile)
            val image = BitmapFactory.decodeStream(inputStream)
            val outBlured: Bitmap = HokoBlur.with(context).blur(image)

            val imageView = view.findViewById<ImageView>(R.id.workImageBlured)
            imageView.setImageBitmap(outBlured)

            view.findViewById<ImageView>(R.id.workImage).setImageBitmap(image)
            view.findViewById<TextView>(R.id.txtArtistWorkDetail).text = work.artistId.toString()
            view.findViewById<TextView>(R.id.txtTitleWorkDetail).text = work.title
        }catch (e: Exception){
            e.printStackTrace()
        }


        return view
    }
}