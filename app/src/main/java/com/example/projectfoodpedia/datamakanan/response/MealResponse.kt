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

/* dikarenakan konten didalam Array JSON yang diinginkan dibungkus oleh array "meals",
* maka di inisialisasikan data class ListMealResponse yang membuka array tersebut agar bisa didapatkan
* variabel-variabel pada data class MealResponse diatas */
data class ListMealResponse(
    @SerializedName("meals")
    val meals: ArrayList<MealResponse>
)