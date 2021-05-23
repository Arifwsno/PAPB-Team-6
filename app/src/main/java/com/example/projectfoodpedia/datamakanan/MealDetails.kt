package com.example.projectfoodpedia.datamakanan

import android.graphics.Picture
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealDetails(
    @SerializedName("idMeal")
    val id: String,

    @SerializedName("strMeal")
    val name: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strInstructions")
    val instruction: String,

    @SerializedName("strMealThumb")
    val picture: String
) : Parcelable

data class ListMealDetails(
    @SerializedName("meals")
    val meals: ArrayList<MealDetails>
)