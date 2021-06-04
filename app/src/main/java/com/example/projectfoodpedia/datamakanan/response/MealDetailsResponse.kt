package com.example.projectfoodpedia.datamakanan

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MealDetailsResponse(
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

/* Dikarenakan konten didalam Array JSON yang diinginkan dibungkus oleh array "meals",
* maka di inisialisasikan data class ListMealDetails yang membuka array tersebut agar bisa didapatkan
* variabel-variabel pada data class MealDetailsResponse diatas */
data class ListMealDetails(
    @SerializedName("meals")
    val mealResponses: ArrayList<MealDetailsResponse>
)