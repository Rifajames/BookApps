package com.example.bookapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val imageSrc: Int,
    val imTitle: String,
    val imAuthor: String,
    val imDescrip: String
) : Parcelable
