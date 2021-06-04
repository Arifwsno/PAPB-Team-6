package com.example.projectfoodpedia.datamakanan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize // Merupakan entitas yang menyimpan data dari API dengan end-point details
data class MealDetailsModel(
        val id: String,

        val name: String,

        val category: String,

        val instruction: String,

        val picture: String,

        val isFavourite: Boolean

) : Parcelable
