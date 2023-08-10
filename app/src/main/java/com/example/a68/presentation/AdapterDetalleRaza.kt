package com.example.a68.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a68.data.local.RazaDetalleEntity
import com.example.a68.databinding.ItemDetalleBinding
import okhttp3.internal.notify

class AdapterDetalleRaza: RecyclerView.Adapter<AdapterDetalleRaza.ItemDetalleViewHolder>() {
    lateinit var binding : ItemDetalleBinding
    private var listDetalleRaza = mutableListOf<RazaDetalleEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDetalleViewHolder {
        binding = ItemDetalleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDetalleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetalleRaza.size
    }

    override fun onBindViewHolder(holder: ItemDetalleViewHolder, position: Int) {
        val razaPerro = listDetalleRaza[position]
        holder.bind(razaPerro)
    }

    fun setDataDetalle(detalles: List<RazaDetalleEntity>){
        this.listDetalleRaza.clear()
        this.listDetalleRaza.addAll(detalles)
        notifyDataSetChanged()
    }

    class ItemDetalleViewHolder(val perrobinding: ItemDetalleBinding) : RecyclerView.ViewHolder(perrobinding.root) {
        fun bind(detalles: RazaDetalleEntity){
            perrobinding.imagenRazaDetalle.load(detalles.url)
        }

    }
}