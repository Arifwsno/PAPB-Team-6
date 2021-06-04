package com.example.projectfoodpedia.datamakanan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Merupakan class yang menyimpan data dari hasil mapping (dialokasikan) dari response module.
// variabel-variabel CategoryModel ini kemudian akan ditampilkan di fragment (User Interface)
@Parcelize
data class CategoryModel (
        val id: String,
        val category: String,
        val picture: String
): Parcelable
