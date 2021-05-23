package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealDetails
import com.example.projectfoodpedia.repository.IMealsRepository

class DetailViewModel(private val mealsRepository: IMealsRepository, private val meal: String) :
    ViewModel() {
    private fun getRepo() = mealsRepository.getDetail(meal)
    fun getDetail(): LiveData<MealDetails> = getRepo()
}