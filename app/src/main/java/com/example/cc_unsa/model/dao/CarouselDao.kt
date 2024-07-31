package com.example.cc_unsa.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.cc_unsa.viewmodel.dto.ArtistItemDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionItemDto
import com.example.cc_unsa.viewmodel.dto.WorkItemDto

@Dao
interface CarouselDao {
    @Query("SELECT a.id, a.name, a.specialty, a.photo FROM artist a")
    fun getAllArtist():LiveData<List<ArtistItemDto>>

    @Query("SELECT e.id, a.name as artistName, e.period, e.name FROM exhibition e, artist a WHERE e.artistId = a.id")
    fun getAllExhibition():LiveData<List<ExhibitionItemDto>>

    @Query("SELECT w.id, w.title, w.technique,w.dimension, w.image FROM work w")
    fun getAllWorks():LiveData<List<WorkItemDto>>
}