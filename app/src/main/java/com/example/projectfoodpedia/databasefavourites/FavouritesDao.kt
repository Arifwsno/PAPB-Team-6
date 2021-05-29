package com.example.projectfoodpedia.databasefavourites

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourites(mealsEntity: List<MealsEntity>)

    @Query("SELECT * FROM favourite_table WHERE isFavourite = 1")
    fun getAllFavouriteMeal () : Flow<List<MealsEntity>>

    @Update
    fun updateFavouriteMeal(mealsEntity: MealsEntity)

    @Query("SELECT * FROM favourite_table WHERE id = :id")
    fun getDetailMeal(id: String) : Flow<MealsEntity>
}