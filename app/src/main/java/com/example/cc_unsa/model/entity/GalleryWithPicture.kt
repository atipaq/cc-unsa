package com.example.cc_unsa.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class GalleryWithPicture(
    @Embedded val gallery: GalleryEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "galleryId"
    )
    val pictures: List<PictureEntity>
)