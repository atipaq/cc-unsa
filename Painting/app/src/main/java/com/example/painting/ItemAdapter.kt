package com.example.painting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.painting.databinding.ItemsRowBinding

class ItemAdapter( private val items: ArrayList<PaintDetail>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.imageView.setImageResource(item.imageId[0])

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    // Interface for the click listener
    interface OnClickListener {
        fun onClick(position: Int, model: PaintDetail)
    }

    // ViewHolder class to hold the views
    class ViewHolder(val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root)
}
