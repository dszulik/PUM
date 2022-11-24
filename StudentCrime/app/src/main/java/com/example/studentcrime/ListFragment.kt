package com.example.studentcrime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {

    private val crimeList = listOf(
        Crime("First", "dont know yet", "123456", false),
        Crime("Second", "still dont know", "234567", true),
        Crime("First", "dont know yet", "345678", false),
        Crime("Second", "still dont know", "456789", true),
        Crime("First", "dont know yet", "567890", false),
        Crime("Second", "still dont know", "678901", true),
        Crime("First", "dont know yet", "135792", false),
        Crime("Second", "still dont know", "124578", true),
        Crime("First", "dont know yet", "975310", false),
        Crime("Second", "still dont know", "124568", true),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CrimeListAdapter(crimeList)
    }

}
