package com.example.projectfoodpedia.usecase

import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.datamakanan.model.MealModel
import com.example.projectfoodpedia.networkresource.Resource
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface IMealUseCase {
    fun getCategory(): Single<List<CategoryModel>>
    fun getListMeal(category: String): Single<List<MealModel>>
    fun getDetail(id: String): Flow<Resource<MealDetailsModel>>
    fun getFavouriteMeal(): Flow<List<MealDetailsModel>>
    fun setFavouriteMeal(mealDetailsModel: MealDetailsModel, state: Boolean)
}