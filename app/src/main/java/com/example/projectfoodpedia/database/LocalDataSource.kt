package com.example.projectfoodpedia.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val favouritesDao: FavouritesDao) {

    suspend fun addFavourites(mealsEntity: List<MealsEntity>) = favouritesDao.addFavourites(mealsEntity)

    fun getAllFavouriteMeal(): Flow<List<MealsEntity>> = favouritesDao.getAllFavouriteMeal()

    fun updateFavouriteMeal(mealsEntity: MealsEntity, state: Boolean) {
        mealsEntity.isFavourite = state
        favouritesDao.updateFavouriteMeal(mealsEntity)
    }

    fun getDetailMeal(id: String): Flow<MealsEntity> = favouritesDao.getDetailMeal(id)
}