package com.example.cc_unsa.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist")
data class ArtistEntity (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "specialty")
    val specialty: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "biography")
    val biography: String,
    @ColumnInfo(name = "awards")
    val awards: String
)