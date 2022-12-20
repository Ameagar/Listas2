package com.keepcoding.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.keepcoding.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainAdapterCallback {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter(this)
    private val list = MutableList(10){
        "soy el elemento $it"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecycler()
        setListeners()
    }

    private fun setListeners(){
        binding.btnAdd.setOnClickListener{
            list.add("soy el elemento ${list.size}")
            adapter.updateList(list)
        }
    }

    private fun updateTitle(title:String){
        binding.tvTitle.text = title
    }

    private fun createRecycler(){

        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        adapter.updateList(list)
    }

    override fun onItemClicked(item: String) {
        updateTitle(item)
    }
}