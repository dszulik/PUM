package com.example.studenthardlife

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenthardlife.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var dbHandler: DBHandler
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = this.context
        if (context != null) {
            dbHandler = DBHandler(context)
        }

        binding.dataBaseRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = TaskAdapter(dbHandler, this.context)
        }

        binding.addButton.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val deadline = binding.editTextDeadline.text.toString()
            val content = binding.editTextContent.text.toString()
            val isDone = binding.editTextIsdone.text.toString()

            if (title.isNotEmpty() && deadline.isNotEmpty() && content.isNotEmpty() && isDone.isNotEmpty() && isDone == "tak" || isDone == "nie"){
                dbHandler.addTask(Task(title, deadline, content, isDone))
                binding.editTextTitle.text.clear()
                binding.editTextDeadline.text.clear()
                binding.editTextContent.text.clear()
                binding.editTextIsdone.text.clear()
            }

            binding.dataBaseRecyclerView.adapter?.notifyItemInserted(dbHandler.getTasks().size)
        }
        return  binding.root
    }

    override fun onDestroy() {
        dbHandler.close()
        super.onDestroy()
    }
}