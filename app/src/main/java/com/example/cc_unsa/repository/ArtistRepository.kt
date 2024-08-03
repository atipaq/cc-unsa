package com.example.cc_unsa.repository

import androidx.lifecycle.LiveData
import com.example.cc_unsa.model.dao.ArtistDao
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.viewmodel.dto.ArtistDto

class ArtistRepository(
    private val artistDao: ArtistDao
) {
    suspend fun insertArtist(artist: ArtistEntity) {
        artistDao.insertArtist(artist)
    }
}