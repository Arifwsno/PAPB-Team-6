package com.example.projectfoodpedia.usecase

import android.util.Log
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.datamakanan.model.MealModel
import com.example.projectfoodpedia.networkresource.Resource
import com.example.projectfoodpedia.repository.IMealsRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

class MealUseCase (private val mealRepository: IMealsRepository): IMealUseCase { // ":" di class untuk inherit
    override fun getCategory(): Single<List<CategoryModel>> { // ":" di fungsi sebagai return type
        return mealRepository.getCategory()
    }

    override fun getListMeal(category: String): Single<List<MealModel>> {
        return mealRepository.getListMeal(category)
    }

    override fun getDetail(id: String): Flow<Resource<MealDetailsModel>> {
        return mealRepository.getDetail(id)
    }

    override fun getFavouriteMeal(): Flow<List<MealDetailsModel>> {
        return mealRepository.getFavouriteMeal()
    }

    override fun setFavouriteMeal(mealDetailsModel: MealDetailsModel, state: Boolean) {
        return mealRepository.setFavouriteMeal(mealDetailsModel, state)
    }

}