package com.example.restcountriesapp.adapters.capitals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.databinding.CapitalListItemBinding

class CapitalsAdapter(itemComparator: CapitalsComparator)
    : ListAdapter<Country, CapitalsViewHolder>(itemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapitalsViewHolder {
        return CapitalsViewHolder(
            CapitalListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CapitalsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}