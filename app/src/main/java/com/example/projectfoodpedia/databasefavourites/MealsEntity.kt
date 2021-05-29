package com.example.projectfoodpedia.databasefavourites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_table")
data class MealsEntity(
        @PrimaryKey
        var id: String,
        var name: String,
        var category: String,
        var instruction: String,
        var picture: String,
        var isFavourite: Boolean
)