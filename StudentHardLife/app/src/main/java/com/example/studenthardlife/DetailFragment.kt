package com.example.studenthardlife

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.studenthardlife.databinding.FragmentDetailBinding
import com.example.studenthardlife.databinding.DialogUpdateBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private lateinit var itemId: String
    private lateinit var dbHandler: DBHandler
    private lateinit var item: Task
    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { itemId = it.getString("itemId").toString() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = this.context
        if(context != null) {
            dbHandler = DBHandler(context)

            item = dbHandler.getTasks().find { item -> item.id.toString() == itemId }!!
            binding.textViewDetailTitle.text = item.title
            binding.textViewDetailDeadline.text = item.deadline
            binding.textViewDetailContent.text = item.content
            binding.textViewDetailIsDone.text = item.isDone

            binding.buttonDetailDelete.setOnClickListener {
                dbHandler.deleteTask(item)
                Navigation.findNavController(binding.root).navigate(R.id.action_DetailFragment_to_ListFragment)
            }

            binding.buttonDetailEdit.setOnClickListener {
                setupDialog(item)
            }

            binding.buttonDetailBack.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_DetailFragment_to_ListFragment)
            }
        }

        return binding.root
    }

    private fun setupDialog(item: Task) {
        val context = this.context
        if (context != null) {
            val dialog = Dialog(context)
            val dialogBinding = DialogUpdateBinding.inflate(LayoutInflater.from(context))
            dialog.apply {
                setCancelable(false)
                setContentView(dialogBinding.root)
            }

            dialogBinding.apply {
                editTextTitleUpdate.setText(item.title.toString())
                editTextDeadlineUpdate.setText(item.deadline.toString())
                editTextContentUpdate.setText(item.content.toString())
                editTextIsDoneUpdate.setText(item.isDone.toString())
                buttonUpdate.setOnClickListener {
                    updateDialog(dialogBinding, item, dialog)
                }

                buttonCancel.setOnClickListener { dialog.dismiss() }
            }
            dialog.show()
        }
    }
        private fun updateDialog(
            dialogBinding: DialogUpdateBinding,
            item: Task,
            dialog: Dialog
        ) {
            val updateTitle = dialogBinding.editTextTitleUpdate.text.toString()
            val updateDeadline = dialogBinding.editTextDeadlineUpdate.text.toString()
            val updateContent = dialogBinding.editTextContentUpdate.text.toString()
            val updateIsDone = dialogBinding.editTextIsDoneUpdate.text.toString()

            if (updateTitle.isNotEmpty() && updateDeadline.isNotEmpty() && updateContent.isNotEmpty() && updateIsDone.isNotEmpty()) {
                dbHandler.updateTask(item.id, updateTitle, updateDeadline, updateContent, updateIsDone )
                dialog.dismiss()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}