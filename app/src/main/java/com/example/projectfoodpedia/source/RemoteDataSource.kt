package com.example.projectfoodpedia.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealDetails
import com.example.projectfoodpedia.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RemoteDataSource {
    private val remoteApiService = ApiService()
    private val disposable = CompositeDisposable()

    private val _categoriesModel: MutableLiveData<ListCategoryResponse> =
        MutableLiveData() //underscore cuman bisa diakses di class itu aja
    private val _mealsModel: MutableLiveData<ListMealResponse> = MutableLiveData()
    private val _detailsModel: MutableLiveData<MealDetails> = MutableLiveData()

    val categoriesModel: LiveData<ListCategoryResponse> //immutable data type
        get() = _categoriesModel
    val mealsModel: LiveData<ListMealResponse>
        get() = _mealsModel
    val detailsModel: LiveData<MealDetails>
        get() = _detailsModel

    fun getListCategories() {
        disposable.add(
            remoteApiService.getListCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) //karena observe di thread utama
                .subscribe({
                    _categoriesModel.postValue(it)
                }, {

                })
        )
    }

    fun getListMeal(c: String?) {
        disposable.add(
            remoteApiService.getListMeal(c)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) //karena observe di thread utama
                .subscribe({
                    _mealsModel.postValue(it)
                }, {

                })
        )
    }

    fun getDetails(i: String) {
        disposable.add(
            remoteApiService.getDetails(i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) //karena observe di thread utama
                .subscribe({
                    _detailsModel.postValue(it.meals[0])
                }, {

                })
        )
    }
}