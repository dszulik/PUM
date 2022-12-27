package com.example.studenthardlife

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthardlife.databinding.ListItemBinding

class TaskAdapter(private val dbHandler: DBHandler, private val context: Context) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Task) {
            itemBinding.textViewTitle.text = item.title
            itemBinding.isDoneImage.visibility = if (item.isDone == "tak") View.VISIBLE else View.INVISIBLE

            itemBinding.textViewTitle.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(itemId = item.id.toString())
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dbHandler.getTasks()[position]
        holder.bind(item)
    }
    override fun getItemCount() = dbHandler.getTasks().size
}
