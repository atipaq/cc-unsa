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
import com.example.cc_unsa.viewmodel.dto.ItemCarouselDtoInterface
import com.example.cc_unsa.viewmodel.dto.WorkItemDto
import java.io.IOException

class CarouselHomeAdapter(private val context: Context, ) :
    RecyclerView.Adapter<ItemViewHolder>() {
    private var items: List<ItemCarouselDtoInterface>? = null
    private var type: Int = 1
    // Método para actualizar los datos
    fun updateData(newItems: List<ItemCarouselDtoInterface>, t:Int) {
        items = newItems
        type = t
        notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_card, parent, false)
        return ItemViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        if(items == null){
            return
        }
        val item = items!![position]
        when (type) {
            0 -> {
                try {
                    Log.e("Image", item.name()!!)
                    val inputStream = context.assets.open("artista/"+item.photo())
                    val drawable = Drawable.createFromStream(inputStream, null)
                    holder.image.setImageDrawable(drawable)
                    inputStream.close()
                } catch (e: IOException) {
                    throw RuntimeException(e)
                }
                holder.title.text = item.name()
                holder.dimension.text = ""
                holder.technique.text = item.specialty()
            }
            1 -> {
                try {
                    val inputStream = context.assets.open("pinturas/"+item.image())
                    val drawable = Drawable.createFromStream(inputStream, null)
                    holder.image.setImageDrawable(drawable)
                    inputStream.close()
                } catch (e: IOException) {
                    throw RuntimeException(e)
                }
                holder.title.text = item.title()
                holder.dimension.text = item.dimension()
                holder.technique.text = item.technique()
            }
            2 -> {
                try {
                    val inputStream = context.assets.open("pinturas/"+item.image())
                    val drawable = Drawable.createFromStream(inputStream, null)
                    holder.image.setImageDrawable(drawable)
                    inputStream.close()
                } catch (e: IOException) {
                    throw RuntimeException(e)
                }
                holder.title.text = item.name()
                holder.dimension.text = item.period()
                holder.technique.text = item.artistName()
            }
        }

    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items!!.size
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
