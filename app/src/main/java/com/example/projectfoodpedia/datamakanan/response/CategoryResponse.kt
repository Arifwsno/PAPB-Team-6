package com.example.projectfoodpedia.datamakanan

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryResponse(
    @SerializedName("idCategory")
    val id: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strCategoryThumb")
    val picture: String
) : Parcelable

data class ListCategoryResponse(
    @SerializedName("categories")
    val categories: List<CategoryResponse>
)