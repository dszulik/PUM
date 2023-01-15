package com.example.restcountriesapp.adapters.flags

import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.databinding.FlagListItemBinding
import com.example.restcountriesapp.model.Country

class FlagsViewHolder(private val binding: FlagListItemBinding)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(item: Country){
        binding.textViewCountryFlag.text = item.name.official
        binding.textViewFlag.text = item.flag
    }
}