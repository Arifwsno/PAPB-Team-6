package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.model.MealModel
import com.example.projectfoodpedia.repository.IMealsRepository
import com.example.projectfoodpedia.usecase.IMealUseCase
import com.example.projectfoodpedia.usecase.MealUseCase
import com.example.projectfoodpedia.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MenuViewModel(private val mealUseCase: IMealUseCase, private val category: String) : BaseViewModel() {
    val dataMeals = MutableLiveData<List<MealModel>>()

    fun getListMeal(){ // ini kaya gini paramternya gara2 buat fungsi
        disposable.add(
                mealUseCase.getListMeal(category)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                                   dataMeals.value = it
                        }, {

                        })
        )
    }

}