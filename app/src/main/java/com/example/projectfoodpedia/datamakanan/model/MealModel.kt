package com.example.projectfoodpedia.datamakanan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize // Merupakan entitas yang menyimpan data dari API dengan end-point meal
data class MealModel(
        val id: String,

        val name: String,

        val picture: String
) : Parcelable