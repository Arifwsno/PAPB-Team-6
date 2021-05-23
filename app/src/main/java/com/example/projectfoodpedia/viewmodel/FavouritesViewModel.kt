package com.example.projectfoodpedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.projectfoodpedia.usecase.IMealUseCase
import com.example.projectfoodpedia.usecase.MealUseCase
import com.example.projectfoodpedia.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(private val mealUseCase: IMealUseCase): BaseViewModel() {
    val dataFavourite = mealUseCase.getFavouriteMeal().asLiveData()
}