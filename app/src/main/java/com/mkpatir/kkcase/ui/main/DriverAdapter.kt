package com.mkpatir.kkcase.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkpatir.kkcase.api.models.DriverData
import com.mkpatir.kkcase.databinding.ItemDriverBinding

class DriverAdapter: RecyclerView.Adapter<DriverAdapter.ViewHolder>() {

    private var items: MutableList<DriverData> = mutableListOf()

    internal var onItemClick:(DriverData) -> Unit = {}
    internal var favoriteClick:(DriverData) -> Unit = {}

    inner class ViewHolder(private val binding: ItemDriverBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DriverData){
            binding.viewState = DriverViewState(binding.root.context,item,bindingAdapterPosition)
            binding.buttonFavorite.setOnClickListener {
                favoriteClick(item)
            }
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDriverBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateAdapter(items: MutableList<DriverData>){
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}