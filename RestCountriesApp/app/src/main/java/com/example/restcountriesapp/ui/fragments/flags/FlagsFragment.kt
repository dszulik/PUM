package com.example.restcountriesapp.ui.fragments.flags

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.adapters.flags.FlagsAdapter
import com.example.restcountriesapp.adapters.flags.FlagsComparator
import com.example.restcountriesapp.databinding.FragmentFlagsBinding
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.util.Resource

class FlagsFragment : Fragment() {

    private lateinit var binding: FragmentFlagsBinding
    private val flagsViewModel: FlagsViewModel by viewModels()
    private val TAG = "FlagsFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlagsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flagsViewModel.getCountries()

        val adapter = FlagsAdapter(FlagsComparator())
        setupRecyclerView(adapter)

        observeCountries(adapter)
    }

    private fun observeCountries(flagsAdapter: FlagsAdapter) {
        flagsViewModel.flags.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { res -> flagsAdapter.submitList(res.map { Country(it.name, it.capital, it.flag) })}
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { Log.e(TAG, "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }

    private fun setupRecyclerView(capitalsAdapter: FlagsAdapter) {
        binding.flagsRecyclerView.apply {
            adapter = capitalsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun hideProgressBar(){
        binding.flagsProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.flagsProgressBar.visibility = View.VISIBLE
    }
}
