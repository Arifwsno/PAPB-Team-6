package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.repository.IMealsRepository

class MenuViewModel(private val mealsRepository: IMealsRepository, private val category: String?) :
    ViewModel() {
    private fun getRepo() = mealsRepository.getListMeal(category)
    fun getListMeal(): LiveData<ListMealResponse> = getRepo()
}