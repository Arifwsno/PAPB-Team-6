package com.example.projectfoodpedia.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MealsEntity::class], version = 1, exportSchema = false)
abstract class FavouritesDatabase: RoomDatabase() {
    abstract fun favouriteDao(): FavouritesDao
}