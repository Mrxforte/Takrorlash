package com.example.takrorlash

import CustomUserAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.takrorlash.databinding.ActivityCustomListViewBinding
import com.example.takrorlash.models.User
import kotlin.random.Random

class CustomListView : AppCompatActivity() {
    private lateinit var binding: ActivityCustomListViewBinding
    private var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCustomListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadData()
        loadUI()
    }

    private fun loadData() {
        for (i in 0..100) {
            list.add(User("Azamat $i", 29))
        }
    }

    private fun loadUI() {
        val adapter = CustomUserAdapter(this, list)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "$i is selected", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailsScreen::class.java)
            intent.putExtra("user", i)
            startActivity(intent)
        }
    }

}