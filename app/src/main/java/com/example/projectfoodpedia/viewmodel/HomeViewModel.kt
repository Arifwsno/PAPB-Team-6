package com.example.projectfoodpedia.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.usecase.IMealUseCase
import com.example.projectfoodpedia.utils.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val mealUseCase: IMealUseCase) : BaseViewModel() {
    val dataCategory = MutableLiveData<List<CategoryModel>>() //of type itu <>

    fun getCategory() {
        disposable.add(
                mealUseCase.getCategory()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            dataCategory.value = it

                        }, {

                        })
        )
    }
}
