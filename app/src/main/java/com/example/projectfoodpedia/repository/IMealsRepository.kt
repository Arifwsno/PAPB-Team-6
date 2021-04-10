package com.example.projectfoodpedia.repository

import androidx.lifecycle.LiveData
import com.example.projectfoodpedia.datamakanan.ListCategoryResponse
import com.example.projectfoodpedia.datamakanan.ListMealDetails
import com.example.projectfoodpedia.datamakanan.ListMealResponse
import com.example.projectfoodpedia.datamakanan.MealDetails

interface IMealsRepository {
    fun getCategory(): LiveData<ListCategoryResponse>
    fun getListMeal(category: String?): LiveData<ListMealResponse>
    fun getDetail(lookup: String): LiveData<MealDetails>
}