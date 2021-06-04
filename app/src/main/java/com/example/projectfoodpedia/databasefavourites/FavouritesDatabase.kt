package com.example.projectfoodpedia.databasefavourites

import androidx.room.Database
import androidx.room.RoomDatabase

// Inisialisasi ROOM Database
@Database(entities = [MealsEntity::class], version = 1, exportSchema = false)
abstract class FavouritesDatabase: RoomDatabase() {
    abstract fun favouriteDao(): FavouritesDao
}