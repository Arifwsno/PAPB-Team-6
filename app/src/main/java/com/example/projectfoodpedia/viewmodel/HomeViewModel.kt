package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.repository.IMealsRepository

class HomeViewModel(private val mealsRepository: IMealsRepository): ViewModel() {
    private fun getRepo() = mealsRepository.getCategory()
    fun getCategory(): LiveData<ListCategoryResponse> = getRepo()
}