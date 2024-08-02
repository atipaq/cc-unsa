package com.example.cc_unsa.viewmodel.dto

data class ExhibitionDto(
    val id: Int?,
    val name: String,
    val galleryId: Int,
    val artistId: Int,
    val period: Int,
    val descriptionText: String,
    val descriotionAudio: String,
    val state: Boolean
)
