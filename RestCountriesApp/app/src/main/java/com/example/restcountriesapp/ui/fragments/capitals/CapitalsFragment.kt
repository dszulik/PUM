package com.example.restcountriesapp.ui.fragments.capitals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restcountriesapp.R
import com.example.restcountriesapp.adapters.capitals.CapitalsAdapter
import com.example.restcountriesapp.adapters.capitals.CapitalsComparator
import com.example.restcountriesapp.databinding.FragmentCapitalsBinding
import com.example.restcountriesapp.model.Country
import com.example.restcountriesapp.util.Resource

class CapitalsFragment : Fragment() {

    private lateinit var binding: FragmentCapitalsBinding
    private val capitalsViewModel: CapitalsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCapitalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        capitalsViewModel.getCountries()

        val adapter = CapitalsAdapter(CapitalsComparator())
        setupRecyclerView(adapter)

        observeCountries(adapter)
    }

    private fun observeCountries(capitalsAdapter: CapitalsAdapter) {
        capitalsViewModel.capitals.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let  { res ->
                        Log.d("RESPONSE_OK", res.toString())
                        capitalsAdapter.submitList(res.map { Country(it.name, it.capital) })}
                }
                is Resource.Error -> {
                    response.message?.let { Log.e("RESPONSE_ERROR", "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }

    private fun setupRecyclerView(capitalsAdapter: CapitalsAdapter) {
        binding.capitalsRecyclerView.apply {
            adapter = capitalsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun hideProgressBar(){
        binding.capitalsProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.capitalsProgressBar.visibility = View.VISIBLE
    }
}
