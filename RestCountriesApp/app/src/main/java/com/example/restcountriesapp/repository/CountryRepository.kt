package com.example.restcountriesapp.repository

import com.example.restcountriesapp.model.CountryResponse
import com.example.restcountriesapp.api.RetrofitInstance
import retrofit2.Response

class CountryRepository {
    suspend fun getCountries(): Response<CountryResponse> = RetrofitInstance.api.getCountries()
}