package com.example.studentcrime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        view.findViewById<Button>(R.id.detailReturnButton).setOnClickListener {
            val action = DetailFragmentDirections.toFragmentList()
            Navigation.findNavController(view).navigate(action)
        }

        view.findViewById<TextView>(R.id.detailTitle).text = arguments?.getString("detailTitle")
        view.findViewById<TextView>(R.id.detailStudentIndex).text = arguments?.getString("detailStudentIndex")
        view.findViewById<TextView>(R.id.detailContent).text = arguments?.getString("detailContent")
        view.findViewById<TextView>(R.id.detailIsSolved).text = arguments?.getString("detailIsSolved")

        return view
    }

}