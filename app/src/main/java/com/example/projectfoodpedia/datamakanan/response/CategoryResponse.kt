package com.example.projectfoodpedia.datamakanan

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// Merupakan entitas yang menyimpan data dari API dengan end-point category
@Parcelize
data class CategoryResponse(
    @SerializedName("idCategory")
    val id: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strCategoryThumb")
    val picture: String
) : Parcelable

/* dikarenakan konten didalam Array JSON yang diinginkan dibungkus oleh array "categories",
* maka di inisialisasikan data class ListCategoryResponse yang membuka array tersebut agar bisa didapatkan
* variabel-variabel pada data class CategoryResponse diatas */
data class ListCategoryResponse(
    @SerializedName("categories")
    val categories: List<CategoryResponse>
)