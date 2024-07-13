package com.example.cc_unsa.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "picture")
data class PictureEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "artistId")
    val artistId: Int,
    @ColumnInfo(name = "galleryId")
    val galleryId: Int,
    @ColumnInfo(name = "technique")
    val technique: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "dimension")
    val dimension: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "image")
    val image: String
)