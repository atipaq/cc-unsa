package com.example.cc_unsa.viewmodel.dto

data class WorkDto(
    val id: Int,
    val title:String,
    val exhibitionId: Int,
    val artistId: Int,
    val technique: String,
    val description: String,
    val dimension: String,
    val year: Int,
    val image: String,
    val positionX: Float,
    val positionY: Float
)
