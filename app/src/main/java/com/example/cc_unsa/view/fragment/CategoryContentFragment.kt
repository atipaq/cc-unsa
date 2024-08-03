package com.example.cc_unsa.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cc_unsa.R

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryContentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryContentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_content, container, false)
    }

    companion object {
        fun newInstance(): CategoryContentFragment {
            val fragment = CategoryContentFragment()

            return fragment
        }
    }
}