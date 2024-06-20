package com.example.cc_unsa.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cc_unsa.R;
import com.example.cc_unsa.adapter.ItemAdapter;
import com.example.cc_unsa.model.dto.ItemDto;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardSliderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardSliderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardSliderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardSliderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardSliderFragment newInstance(String param1, String param2) {
        CardSliderFragment fragment = new CardSliderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_slider, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_items_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ArrayList<ItemDto> items = new ArrayList<>();
        items.add(ItemDto.builder().category("Category 1").title("Title 1").description("Description 1").imageUrl("https://via.placeholder.com/150").build());
        items.add(ItemDto.builder().category("Category 2").title("Title 2").description("Description 2").imageUrl("https://via.placeholder.com/150").build());
        items.add(ItemDto.builder().category("Category 3").title("Title 3").description("Description 3").imageUrl("https://via.placeholder.com/150").build());

        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);

        return view;
    }
}