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
        Crime("First", "paste your own description here", "123456", false),
        Crime("Second", "paste your own description here", "234567", true),
        Crime("Third", "paste your own description here", "345678", false),
        Crime("Fourth", "paste your own description here", "456789", true),
        Crime("Fifth", "paste your own description here", "567890", false),
        Crime("Sixth", "paste your own description here", "678901", true),
        Crime("Seventh", "paste your own description here", "135792", false),
        Crime("Eight", "paste your own description here", "124578", true),
        Crime("Ninth", "paste your own description here", "975310", false),
        Crime("Tenth", "paste your own description here", "124568", true),
        Crime("Eleventh", "paste your own description here", "123456", false),
        Crime("Twelfth", "paste your own description here", "234567", true),
        Crime("Thirteenth", "paste your own description here", "345678", false),
        Crime("Fourteenth", "paste your own description here", "456789", true),
        Crime("Fifteenth", "paste your own description here", "567890", false),
        Crime("Sixteenth", "paste your own description here", "678901", true),
        Crime("Seventeenth", "paste your own description here", "135792", false),
        Crime("Eighteenth", "paste your own description here", "124578", true),
        Crime("Nineteenth", "paste your own description here", "975310", false),
        Crime("Twentyth", "paste your own description here", "124568", true),
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
