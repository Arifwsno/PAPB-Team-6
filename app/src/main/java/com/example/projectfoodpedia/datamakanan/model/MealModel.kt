package com.example.projectfoodpedia.datamakanan.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealModel(
        val id: String,

        val name: String,

        val picture: String
) : Parcelable