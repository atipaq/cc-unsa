package com.example.cc_unsa.model.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.model.entity.WorkEntity

data class ExhibitionWithWorks(
    @Embedded val exhibition: ExhibitionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "exhibitionId"
    )
    val works: List<WorkEntity>
)
