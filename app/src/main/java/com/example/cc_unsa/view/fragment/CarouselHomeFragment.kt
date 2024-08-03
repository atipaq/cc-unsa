package com.example.cc_unsa.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cc_unsa.R
import com.example.cc_unsa.view.adapter.CarouselHomeAdapter
import com.example.cc_unsa.viewmodel.CarouselViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [CarouselHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarouselHomeFragment : Fragment() {
    //Carousel View model
    private val carouselViewModel: CarouselViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: CarouselHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carousel_home, container, false)
        itemAdapter = CarouselHomeAdapter(requireContext())
        updateList(2)
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_items_home)
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        return view
    }
    fun updateList(i : Int){
        when (i) {
            0 -> {
                carouselViewModel.allArtists.observe(viewLifecycleOwner) { artists ->
                    artists?.let {
                        Log.e("Artists", artists.toString())
                        itemAdapter.updateData(artists,0)
                        recyclerView.adapter = itemAdapter
                    }
                }
            }
            1 -> {
                carouselViewModel.allWorks.observe(viewLifecycleOwner) { works ->
                    works?.let {
                        itemAdapter.updateData(works,1)
                        recyclerView.adapter = itemAdapter
                    }
                }
            }
            2 -> {
                carouselViewModel.allExhibitions.observe(viewLifecycleOwner) { exhibitions ->
                    exhibitions?.let {
                        itemAdapter.updateData(exhibitions,2)
                        recyclerView.adapter = itemAdapter
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(): CarouselHomeFragment {
            val fragment = CarouselHomeFragment()
            return fragment
        }
    }
}