package com.example.projectfoodpedia.datamakanan

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealResponse(
    @SerializedName("idMeal")
    val id: String,

    @SerializedName("strMeal")
    val name: String,

    @SerializedName("strMealThumb")
    val picture: String
) : Parcelable

data class ListMealResponse(
    @SerializedName("meals")
    val meals: ArrayList<MealResponse>
)