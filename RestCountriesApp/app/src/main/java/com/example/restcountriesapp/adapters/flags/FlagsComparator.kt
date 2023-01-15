package com.example.restcountriesapp.adapters.flags

import androidx.recyclerview.widget.DiffUtil
import com.example.restcountriesapp.model.Country

class FlagsComparator  : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}