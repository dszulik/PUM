package com.example.studentcrime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class CrimeListAdapter(private val crimesList: List<Crime>) : RecyclerView.Adapter<CrimeListAdapter.CrimeListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.crime_list_item, parent, false)
        return CrimeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int) {
        holder.title.text = crimesList[position].title
        holder.image.visibility = if (crimesList[position].solved) View.VISIBLE else View.INVISIBLE
    }

    override fun getItemCount() = crimesList.size

    inner class CrimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.isSolved)

        init {
            itemView.setOnClickListener {
                val args = Bundle()
                args.putString("detailTitle", crimesList[adapterPosition].title)
                args.putString("detailContent", "Description: ${crimesList[adapterPosition].content}")
                args.putString("detailStudentIndex", "Student's index: ${crimesList[adapterPosition].index}")
                args.putString("detailIsSolved", if (crimesList[adapterPosition].solved) "Solved: YES" else "Solved: NO")

                Navigation.findNavController(itemView).navigate(R.id.to_fragmentDetail, args)
            }
        }
    }
}

