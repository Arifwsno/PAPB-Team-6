package com.example.projectfoodpedia.service

import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.utils.Constant
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class ApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealsApi::class.java)

    fun getListCategories(): Observable<ListCategoryResponse> {
        return retrofit.getListCategories()
    }

    fun getListMeal(c: String?): Observable<ListMealResponse> {
        return retrofit.getListMeal(c)
    }

    fun getDetails(i: String): Observable<ListMealDetails> {
        return retrofit.getDetails(i)
    }
}