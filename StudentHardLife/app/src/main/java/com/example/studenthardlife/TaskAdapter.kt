package com.example.studenthardlife

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val dbHandler: DBHandler) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val title : TextView = itemView.findViewById(R.id.title)

        fun bind(item: Task) {
            title.text = item.title
//            isDone.text = item.isDone.toString()

            itemView.setOnClickListener {
//                dbHandler.getTasks()
//                val args = Bundle()
//                Navigation.findNavController(itemView).navigate(R.id.action_ListFragment_to_DetailFragment, args)
                val action = ListFragmentDirections.toDetailFragment()
                Navigation.findNavController(itemView).navigate(action)
            }
        }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dbHandler.getTasks()[position]
        holder.bind(item)
    }
    override fun getItemCount() = dbHandler.getTasks().size
}
