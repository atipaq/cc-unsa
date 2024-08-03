package com.example.cc_unsa.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.model.entity.WorkEntity

data class ArtistWithWorks(
    @Embedded val artist: ArtistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "artistId"
    )
    val pictures: List<WorkEntity>
)
