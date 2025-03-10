package com.example.takrorlash

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.takrorlash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferences = getPreferences(MODE_PRIVATE)
        counter = sharedPreferences.getInt("counter", 0)
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
        var animation = AnimationUtils.loadAnimation(this, R.anim.combine_animation)
        binding.counterText.text = counter.toString()
        binding.incrementButton.setOnClickListener() {
            counter++
            binding.counterText.animation = animation
            sharedPreferences.edit().putInt("counter", counter).apply()
            binding.counterText.text = counter.toString()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.simpleListView -> {
                val intent = Intent(this@MainActivity, SimpleListView::class.java)
                startActivity(intent)
                Toast.makeText(
                    this,
                    "Simple List View is selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.customListView -> {
                val intent = Intent(this, CustomListView::class.java)
                startActivity(intent)
                Toast.makeText(this, "Custom ListView is selected", Toast.LENGTH_SHORT).show()
            }

            R.id.gridView -> {
                Toast.makeText(this, "GridView is selected", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, GridViewScreen::class.java)
                startActivity(intent)
            }

            R.id.java -> Toast.makeText(this, "Java is selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        sharedPreferences.edit().putInt("counter", counter).apply()
        super.onStop()
    }
}