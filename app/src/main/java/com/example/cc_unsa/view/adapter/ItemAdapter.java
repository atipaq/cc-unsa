package com.example.cc_unsa.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cc_unsa.R;
import com.example.cc_unsa.model.dto.PictureItemDto;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<PictureItemDto> items;

    public ItemAdapter(List<PictureItemDto> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_card, parent, false);
        return new ItemViewHolder(card_view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        PictureItemDto item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getTechnique());
    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
        }
    }
}
