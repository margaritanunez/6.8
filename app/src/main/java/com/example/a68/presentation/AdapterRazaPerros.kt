package com.example.a68.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a68.data.local.RazaPerrosEntity
import com.example.a68.data.remote.RazaPerros
import com.example.a68.databinding.ItemLayoutBinding

class AdapterRazaPerros : RecyclerView.Adapter<AdapterRazaPerros.ItemLayoutViewHolder>() {
    private lateinit var binding: ItemLayoutBinding
    private val listItemRazas = mutableListOf<RazaPerrosEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLayoutViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemLayoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemLayoutViewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    fun setData(razas: List<RazaPerrosEntity>){ //listado, obviamente plural
        this.listItemRazas.clear()
        this.listItemRazas.addAll(razas)
        notifyDataSetChanged()
    }


    class ItemLayoutViewHolder (val razabinding: ItemLayoutBinding) : RecyclerView.ViewHolder(razabinding.root) {
        fun bind(razaPerros: RazaPerrosEntity){
            razabinding.tvRazasPerros.text = razaPerros.raza
        }

    }
}