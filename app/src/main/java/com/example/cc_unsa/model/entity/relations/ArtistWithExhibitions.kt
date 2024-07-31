package com.example.cc_unsa.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.model.entity.ExhibitionEntity

data class ArtistWithExhibitions(
    @Embedded val artist: ArtistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "artistId"
    )
    val exhibitions: List<ExhibitionEntity>
)
