package com.keepcoding.listas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.keepcoding.listas.databinding.MainItemBinding

interface MainAdapterCallback {
    fun onItemClicked(item: String)
}

class MainAdapter(var callback: MainAdapterCallback) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var items = listOf<String>()
    inner class MainViewHolder(private val binding:MainItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: String,position: Int){
            binding.tvName.text = item
            binding.tvAge.text = "$position"
            binding.root.setOnClickListener{
                Toast.makeText(binding.root.context, item, Toast.LENGTH_LONG).show()
                callback.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //
        return MainViewHolder(
            MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        //Para indicar cuantos elementos mostraremos en nuestra lista
        return items.size
    }

    fun updateList(list: List<String>) {
        items = list
        notifyDataSetChanged()
    }
}