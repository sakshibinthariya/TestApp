package com.example.testapp.model

import androidx.annotation.DrawableRes

data class CuisineType(
    @DrawableRes var imageResource: Int,
    val cuisineName: String,
    var sublistItems: ArrayList<DishesList>
)