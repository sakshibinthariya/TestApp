package com.example.testapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.model.DishesList
import com.example.testapp.databinding.AdapterListItemBinding

class ItemListAdapter(private var dishesList: MutableList<DishesList>) :
    RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>(),
    Filterable {
    private lateinit var context: Context
    private var filteredImages: MutableList<DishesList> =
        mutableListOf<DishesList>().apply {
            addAll(dishesList)
        }

    inner class ItemViewHolder(private val binding: AdapterListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DishesList) {
            binding.txvDishName.text = data.name
            binding.aivImage.setImageResource(data.imageResource)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = AdapterListItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(filteredImages[position])
    }

    override fun getItemCount(): Int {
        return filteredImages.size
    }

    override fun getFilter(): Filter {
        return FilterData()
    }

    inner class FilterData : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            filteredImages = if (constraint == null || constraint.isEmpty()) {
                dishesList
            } else {
                val newList = mutableListOf<DishesList>()
                dishesList.filter {
                    it.name.lowercase().contains(constraint.toString().lowercase())
                }.forEach {
                    newList.add(it)
                }
                newList
            }

            return FilterResults().apply { values = filteredImages }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredImages =
                if (results?.values == null) mutableListOf() else results.values as MutableList<DishesList>
            notifyDataSetChanged()
        }
    }

    fun updateData(newImages: MutableList<DishesList>) {
        dishesList.clear()
        filteredImages.clear()
        dishesList.addAll(newImages)
        filteredImages.addAll(dishesList)
        notifyDataSetChanged()
    }
}