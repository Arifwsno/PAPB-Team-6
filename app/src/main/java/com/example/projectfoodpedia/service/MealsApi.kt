package com.example.projectfoodpedia.service

import com.example.projectfoodpedia.datamakanan.CategoryResponse
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getListCategories(): Single<ListCategoryResponse> //observable bakal nungguin data terus || ada lagi single yang cuman sekali nerima


    @GET("filter.php")
    fun getListMeal(@Query("c") c: String?): Single<ListMealResponse>


    @GET("lookup.php")
    suspend fun getDetails(@Query("i") i: String): ListMealDetails
}