package com.example.painting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ImageAdapterViewPager(private val imagesList : ArrayList<Int>, private val viewPager2 : ViewPager2)
    : RecyclerView.Adapter<ImageAdapterViewPager.ImageViewHolder>() {

    class ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapterViewPager.ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(imagesList[position])
        if (position == imagesList.size - 1){
            viewPager2.post(runnable)
        }
    }
    override fun getItemCount(): Int {
        return imagesList.size
    }
    private val runnable = Runnable {
        imagesList.addAll(imagesList)
        notifyDataSetChanged()
    }
}
