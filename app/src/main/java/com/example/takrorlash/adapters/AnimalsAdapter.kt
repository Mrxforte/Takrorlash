package com.example.takrorlash.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.takrorlash.R
import com.example.takrorlash.databinding.GridItemLayoutBinding
import com.example.takrorlash.models.AnimalsModel

class AnimalsAdapter(context: Context, val list: ArrayList<AnimalsModel>) :
    ArrayAdapter<AnimalsModel>(context, R.layout.grid_item_layout, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: GridItemLayoutBinding = if (convertView == null) {
            GridItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            GridItemLayoutBinding.bind(convertView)
        }
        binding.myImg.setImageResource(list[position].img)
        binding.name.text = list[position].name
        return binding.root
    }
}