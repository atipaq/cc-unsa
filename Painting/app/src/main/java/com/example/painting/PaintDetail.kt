package com.example.painting

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaintDetail(
    val imageId: List<Int>
) : Parcelable

//replace class Employee