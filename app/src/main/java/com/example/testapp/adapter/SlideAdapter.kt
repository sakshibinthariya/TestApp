package com.example.testapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.model.CuisineType
import com.example.testapp.databinding.ItemImageSliderAdapterBinding

class SlideAdapter(private val cuisineList: List<CuisineType>) :
    RecyclerView.Adapter<SlideAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemImageSliderAdapterBinding = ItemImageSliderAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cuisineType = cuisineList[position].cuisineName
        val image = cuisineList[position].imageResource
        holder.bind(image, cuisineType)
    }

    override fun getItemCount(): Int {
        return cuisineList.size
    }

    class ViewHolder(private var itemHolderBinding: ItemImageSliderAdapterBinding) :
        RecyclerView.ViewHolder(itemHolderBinding.root) {
        fun bind(image: Int, cuisineType: String) {
            itemHolderBinding.imvCuisine.setImageResource(image)
            itemHolderBinding.txvCuisine.text = cuisineType
        }
    }
}