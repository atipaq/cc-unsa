package com.example.cc_unsa.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work")
data class WorkEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "exhibitionId")
    val exhibitionId: Int,
    @ColumnInfo(name = "artistId")
    val artistId: Int,
    @ColumnInfo(name = "technique")
    val technique: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "dimension")
    val dimension: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "positionX")
    val positionX: Float,
    @ColumnInfo(name = "positionY")
    val positionY: Float
)