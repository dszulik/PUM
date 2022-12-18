package com.example.studenthardlife

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.studenthardlife.databinding.FragmentTaskOverviewBinding
import com.example.studenthardlife.databinding.ActivityMainBinding
import com.example.studenthardlife.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {

//    private var _binding: FragmentListBinding? = null
//    private lateinit var dbHandler: DBHandler

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
            layoutManager = LinearLayoutManager(context)
            adapter = TaskAdapter(dbHandler)
        }

        binding.addButton.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val deadline = binding.editTextDeadline.text.toString()
            val content = binding.editTextContent.text.toString()
            val isDone = binding.editTextIsdone.text.toString()

            if (title.isNotEmpty() && deadline.isNotEmpty()){
                dbHandler.addTask(Task(title, deadline,content, isDone.toBoolean() ))
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