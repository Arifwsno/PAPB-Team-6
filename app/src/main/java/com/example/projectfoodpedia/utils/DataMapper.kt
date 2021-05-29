package com.example.projectfoodpedia.utils

import com.example.projectfoodpedia.databasefavourites.MealsEntity
import com.example.projectfoodpedia.datamakanan.CategoryResponse
import com.example.projectfoodpedia.datamakanan.MealDetailsResponse
import com.example.projectfoodpedia.datamakanan.MealResponse
import com.example.projectfoodpedia.datamakanan.model.CategoryModel
import com.example.projectfoodpedia.datamakanan.model.MealDetailsModel
import com.example.projectfoodpedia.datamakanan.model.MealModel

//Buat clean architecture
object DataMapper {
    fun mapCategoryResponsesToDomain(input: List<CategoryResponse>): List<CategoryModel> {
        val categoryList = ArrayList<CategoryModel>()
        input.map {
            val category = CategoryModel(
                    id = it.id,
                    category = it.category,
                    picture = it.picture
            )
            categoryList.add(category)
        }
        return categoryList
    }

    fun mapMealResponseToDomain(input: List<MealResponse>): List<MealModel> {
        val mealList = ArrayList<MealModel>()
        input.map {
            val meal = MealModel(
                    id = it.id,
                    name = it.name,
                    picture = it.picture
            )
            mealList.add(meal)
        }
        return mealList
    }

    fun mapMealDetailsResponseToEntity(input: List<MealDetailsResponse>): List<MealsEntity> {
        val detailList = ArrayList<MealsEntity>()
        input.map {
            val detail = MealsEntity(
                    id = it.id,
                    name = it.name,
                    category = it.category,
                    instruction = it.instruction,
                    picture = it.picture,
                    isFavourite = false
            )
            detailList.add(detail)
        }
        return detailList
    }

    fun mapMealDetailEntitiesToDomains(input: List<MealsEntity>): List<MealDetailsModel> =
            input.map {
                MealDetailsModel(
                        id = it.id,
                        name = it.name,
                        category = it.category,
                        instruction = it.instruction,
                        picture = it.picture,
                        isFavourite = it.isFavourite
                )
            }

    fun mapMealDetailEntityToDomain(input: MealsEntity?) = MealDetailsModel(
            id = input?.id ?: "",
            name = input?.name ?: "",
            category = input?.category ?: "",
            instruction = input?.instruction ?: "",
            picture = input?.picture ?: "",
            isFavourite = input?.isFavourite ?: false
    )

    fun mapMealDetailDomainToEntity(input: MealDetailsModel) = MealsEntity(
            id = input.id,
            name = input.name,
            category = input.category,
            instruction = input.instruction,
            picture = input.picture,
            isFavourite = input.isFavourite
    )

}