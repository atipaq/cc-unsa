package com.example.cc_unsa.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cc_unsa.R
import com.example.cc_unsa.model.dto.PictureItemDto
import com.example.cc_unsa.view.adapter.ItemAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [CardSliderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardSliderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card_slider, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_items_home)
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val items = mutableListOf<PictureItemDto>()
        items.add(PictureItemDto(1, "Pintura 1", "Pintura", "Oleo", "20x30", "https://www.w3schools.com/w3images/mountains.jpg"))
        items.add(PictureItemDto(2, "Pintura 2", "Pintura", "Oleo", "20x30", "https://www.w3schools.com/w3images/mountains.jpg"))
        items.add(PictureItemDto(3, "Pintura 3", "Pintura", "Oleo", "20x30", "https://www.w3schools.com/w3images/mountains.jpg"))
        items.add(PictureItemDto(4, "Pintura 4", "Pintura", "Oleo", "20x30", "https://www.w3schools.com/w3images/mountains.jpg"))
        items.add(PictureItemDto(5, "Pintura 5", "Pintura", "Oleo", "20x30", "https://www.w3schools.com/w3images/mountains.jpg"))

        val itemAdapter = ItemAdapter(items)
        recyclerView.adapter = itemAdapter

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