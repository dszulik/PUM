package com.example.studentcrime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrimeListAdapter(private val crimesList: List<Crime>) : RecyclerView.Adapter<CrimeListAdapter.CrimeListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeListAdapter.CrimeListViewHolder {
        return CrimeListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.crime_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int) {
        holder.title.text = crimesList[position].title
        holder.image.visibility = if(crimesList[position].solved) View.VISIBLE else View.INVISIBLE
    }

    override fun getItemCount() = crimesList.size


    class CrimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.isSolved)
    }
}