package com.example.restcountriesapp.adapters.capitals

import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.databinding.CapitalListItemBinding

class CapitalsViewHolder(private val binding: CapitalListItemBinding)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(item: Country){
        binding.textViewCountry.text = item.name.official
        binding.textViewCapital.text = item.capital?.first()
        }
    }