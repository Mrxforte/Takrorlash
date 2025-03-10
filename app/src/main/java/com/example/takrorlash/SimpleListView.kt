package com.example.takrorlash

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.takrorlash.databinding.ActivitySimpleListViewBinding

class SimpleListView : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
    }

    private fun loadUI() {
        val list = ArrayList<String>()
        for (i in 0..100) {
            list.add("Hello Nikolay $i")
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
            binding.listView.adapter = adapter
            binding.listView.setOnItemClickListener { adapterView, view, i, l ->
                Toast.makeText(this, "$i is selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}