package com.example.cc_unsa.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ArtistWithPicture(
    @Embedded val artist: ArtistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "artistId"
    )
    val pictures: List<PictureEntity>
)
