package com.example.cc_unsa.viewmodel.dto

import org.intellij.lang.annotations.JdkConstants.TitledBorderTitlePosition

data class WorkInGalleryDto(
    val id: Int,
    val title: String,
    val image: String,
    val positionX: Float,
    val positionY: Float,
)
