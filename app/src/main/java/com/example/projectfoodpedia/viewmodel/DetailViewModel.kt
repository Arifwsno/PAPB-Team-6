package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.usecase.IMealUseCase

//Controller dari clean architecture
class DetailViewModel(private val mealUseCase: IMealUseCase, private val id: String) : ViewModel() {
    val dataDetail = mealUseCase.getDetail(id).asLiveData()
    fun setFavouriteMeals(mealDetailsModel: MealDetailsModel, state: Boolean){
        mealUseCase.setFavouriteMeal(mealDetailsModel, state)
    }
}