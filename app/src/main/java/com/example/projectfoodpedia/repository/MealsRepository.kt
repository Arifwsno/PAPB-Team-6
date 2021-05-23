package com.example.projectfoodpedia.repository

import androidx.lifecycle.LiveData
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealDetails
import com.example.projectfoodpedia.source.RemoteDataSource

class MealsRepository(private val remoteDataSource: RemoteDataSource) : IMealsRepository {
    override fun getCategory(): LiveData<ListCategoryResponse> {
        remoteDataSource.getListCategories()
        return remoteDataSource.categoriesModel
    }

    override fun getListMeal(category: String?): LiveData<ListMealResponse> {
        remoteDataSource.getListMeal(category)
        return remoteDataSource.mealsModel
    }

    override fun getDetail(lookup: String): LiveData<MealDetails> {
        remoteDataSource.getDetails(lookup)
        return remoteDataSource.detailsModel
    }
}