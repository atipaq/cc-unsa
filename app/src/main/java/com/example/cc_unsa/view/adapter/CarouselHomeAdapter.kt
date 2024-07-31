package com.example.cc_unsa.view.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cc_unsa.R
import com.example.cc_unsa.view.adapter.CarouselHomeAdapter.ItemViewHolder
import com.example.cc_unsa.viewmodel.dto.WorkItemDto
import java.io.IOException

class CarouselHomeAdapter(private val context: Context, private val items: List<WorkItemDto>?) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_card, parent, false)
        return ItemViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items!![position]
        try {
            val inputStream = context.assets.open("pinturas/"+item.image)
            val drawable = Drawable.createFromStream(inputStream, null)
            holder.image.setImageDrawable(drawable)
            inputStream.close()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        holder.title.text = item.title
        holder.dimension.text = item.dimension
        holder.technique.text = item.technique
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.size
        }
        return 0
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.CarouserItemImgView)
        var title: TextView = itemView.findViewById(R.id.item_title)
        var dimension: TextView = itemView.findViewById(R.id.item_dimension)
        var technique: TextView = itemView.findViewById(R.id.item_technique)
    }
}
