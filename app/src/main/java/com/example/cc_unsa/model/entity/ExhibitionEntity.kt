package com.example.cc_unsa.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exhibition")
data class ExhibitionEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "galleryId")
    val galleryId: Int,
    @ColumnInfo(name = "artistId")
    val artistId: Int,
    @ColumnInfo(name = "period")
    val period: Int,
    @ColumnInfo(name = "descriptionText")
    val descriptionText: String,
    @ColumnInfo(name = "descriotionAudio")
    val descriotionAudio: String,
    @ColumnInfo(name = "state")
    val state: Boolean
)
