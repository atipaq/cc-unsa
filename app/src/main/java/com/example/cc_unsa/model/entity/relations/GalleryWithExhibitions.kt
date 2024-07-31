package com.example.cc_unsa.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.model.entity.GalleryEntity

data class GalleryWithExhibitions(
    @Embedded val gallery: GalleryEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "galleryId"
    )
    val exhibitions: List<ExhibitionEntity>
)