package com.example.cc_unsa.view.fragment

import android.os.Bundle
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
 * Use the [CardSliderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardSliderFragment : Fragment() {
    //Carousel View model
    private val carouselViewModel: CarouselViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card_slider, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_items_home)
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        //Obtener la lista de obras
        carouselViewModel.allWorks.observe(viewLifecycleOwner) { works ->
            // Update the cached copy of the words in the adapter.
            works?.let {
                val itemAdapter =
                    this.context?.let { it1 -> CarouselHomeAdapter(it1,works) }
                recyclerView.adapter = itemAdapter
            }
        }

        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CardSliderFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): CardSliderFragment {
            val fragment = CardSliderFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}