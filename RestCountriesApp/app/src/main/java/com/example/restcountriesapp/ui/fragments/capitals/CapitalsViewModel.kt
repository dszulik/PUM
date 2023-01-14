package com.example.restcountriesapp.ui.fragments.capitals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountriesapp.model.CountryResponse
import com.example.restcountriesapp.repository.CountryRepository
import com.example.restcountriesapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class CapitalsViewModel: ViewModel() {

    private val repository = CountryRepository()
    private val _capitals: MutableLiveData<Resource<CountryResponse>> = MutableLiveData()

    val capitals: LiveData<Resource<CountryResponse>>
    get() = _capitals

    fun getCountries() = viewModelScope.launch {
        _capitals.postValue(Resource.Loading())
        val response = repository.getCountries()
        _capitals.postValue(handleCountryResponse(response))
    }

    private fun handleCountryResponse(response: Response<CountryResponse>)
            : Resource<CountryResponse>{
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }
}