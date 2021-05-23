package com.example.projectfoodpedia.repository

import com.example.projectfoodpedia.datamakanan.CategoryResponse
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealResponse
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.datamakanan.model.MealModel
import com.example.projectfoodpedia.networkresource.Resource
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface IMealsRepository {
    fun getCategory(): Single<List<CategoryModel>>
    fun getListMeal(category: String): Single<List<MealModel>>
    fun getDetail(id: String): Flow<Resource<MealDetailsModel>>
    fun getFavouriteMeal(): Flow<List<MealDetailsModel>>
    fun setFavouriteMeal(mealDetailsModel: MealDetailsModel, state: Boolean)
}