package com.example.cc_unsa.viewmodel.dto

data class ExhibitionInfoInMapDto (
    val id: Int?,
    val name: String,
    val galleryName: String,
    val artistName: String,
    val period: Int,
    val descriptionText: String,
    val descriotionAudio: String,
    val state: Boolean
)