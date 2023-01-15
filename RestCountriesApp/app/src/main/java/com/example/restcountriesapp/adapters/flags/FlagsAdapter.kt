package com.example.restcountriesapp.adapters.flags

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.restcountriesapp.databinding.FlagListItemBinding
import com.example.restcountriesapp.model.Country

class FlagsAdapter(itemComparator: FlagsComparator)
    : ListAdapter<Country, FlagsViewHolder>(itemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagsViewHolder {
        return FlagsViewHolder(
            FlagListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun onBindViewHolder(holder: FlagsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}