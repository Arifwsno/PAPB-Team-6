package com.example.projectfoodpedia.datamakanan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel (
        val id: String,
        val category: String,
        val picture: String
): Parcelable
