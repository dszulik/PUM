package com.example.studentcrime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrimeListAdapter(private val context: ListFragment, private val wordList: MutableList<String>) : RecyclerView.Adapter<CrimeListAdapter.CrimeListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeListAdapter.CrimeListViewHolder {
        return CrimeListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_list,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int) {
        val word = wordList[position]
        holder.word.text = word
    }

    override fun getItemCount() = wordList.size


    class CrimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val word: TextView = itemView.findViewById((R.id.singleWord))
    }
}