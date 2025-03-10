package com.example.takrorlash

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.takrorlash.databinding.ActivityGridViewDetailsBinding
import com.example.takrorlash.models.AnimalsModel

class GridViewDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridViewDetailsBinding
    var list = arrayListOf<AnimalsModel>(
        AnimalsModel("Animal 1", R.drawable.img),
        AnimalsModel("Animal 2", R.drawable.img1),
        AnimalsModel("Animal 3", R.drawable.img2),
        AnimalsModel("Animal 4", R.drawable.img3),
        AnimalsModel("Animal 5", R.drawable.img4),
        AnimalsModel("Animal 6", R.drawable.img5),
        AnimalsModel("Animal 7", R.drawable.img6),
        AnimalsModel("Animal 8", R.drawable.img7),
        AnimalsModel("Animal 9", R.drawable.img8),
        AnimalsModel("Animal 10", R.drawable.img9),
        AnimalsModel("Animal 11", R.drawable.img10),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGridViewDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pos = intent.getIntExtra("img", 0)
        binding.image.setImageResource(list[pos].img)
        supportActionBar?.title = list[pos].name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}