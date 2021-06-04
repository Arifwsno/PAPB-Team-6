package com.example.projectfoodpedia.databasefavourites

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao // Data access object
interface FavouritesDao {

    // query untuk mengelola ROOM Database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourites(mealsEntity: List<MealsEntity>)

    // Terdapat kolom isFavourite yang menunjukan kalau user mem-favouritekan sebuah makanan, dimana
    // angka 1 menunjukan makanan di tag favourite, maka query ini menunjukan semua makanan favourite
    @Query("SELECT * FROM favourite_table WHERE isFavourite = 1")
    fun getAllFavouriteMeal () : Flow<List<MealsEntity>>

    // digunakan untuk set nilai isFavourite
    @Update
    fun updateFavouriteMeal(mealsEntity: MealsEntity)

    @Query("SELECT * FROM favourite_table WHERE id = :id")
    fun getDetailMeal(id: String) : Flow<MealsEntity>
}