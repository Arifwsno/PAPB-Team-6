package com.example.projectfoodpedia.service

import com.example.projectfoodpedia.datamakanan.CategoryResponse
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getListCategories(): Observable<ListCategoryResponse> //observable bakal nungguin data terus || ada lagi single yang cuman sekali nerima


    @GET("filter.php")
    fun getListMeal(@Query("c") c: String?): Observable<ListMealResponse>


    @GET("lookup.php")
    fun getDetails(@Query("i") i: String): Observable<ListMealDetails>
}