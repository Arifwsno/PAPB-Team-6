package com.example.projectfoodpedia.source

import android.util.Log
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealDetailsResponse
import com.example.projectfoodpedia.service.ApiResponse
import com.example.projectfoodpedia.service.MealsApi
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val mealsApi: MealsApi) {
    fun getCategory(): Single<ListCategoryResponse> {
        return mealsApi.getListCategories()
    }

    fun getListMeal(c: String): Single<ListMealResponse> {
        return mealsApi.getListMeal(c)
    }

    suspend fun getDetails(i: String) : Flow<ApiResponse<List<MealDetailsResponse>>>{
        return flow {
            try {
                val response = mealsApi.getDetails(i)
                val dataArray = response.mealResponses
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.mealResponses))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}