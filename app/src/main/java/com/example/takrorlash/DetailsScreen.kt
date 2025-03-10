package com.example.takrorlash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.takrorlash.databinding.ActivityDetailsScreenBinding
import com.example.takrorlash.models.User

class DetailsScreen : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsScreenBinding
    private var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadUI()
    }

    @SuppressLint("SetTextI18n")
    private fun loadUI() {

        for (i in 0..100) {
            list.add(User("Azamat $i", 29))
        }
        val pos = intent.getIntExtra("user", 0)
        supportActionBar?.title = list[pos].name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.name.text = list[pos].name
        binding.age.text = list[pos].age.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home
        ) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}