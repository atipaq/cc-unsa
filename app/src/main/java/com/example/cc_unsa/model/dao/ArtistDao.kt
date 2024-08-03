package com.example.cc_unsa.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.viewmodel.dto.ArtistItemDto
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.viewmodel.dto.ArtistDto

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtist(artist: ArtistEntity)

    @Delete
    suspend fun deleteArtist(entity: ArtistEntity)

    @Query("SELECT * FROM artist a WHERE a.id = :id")
    suspend fun getArtistById(id: Int): ArtistEntity

    @Query("SELECT a.id, a.name, a.specialty, a.photo FROM artist a WHERE a.id = :id")
    suspend fun getArtistItemById(id: Int): ArtistItemDto

    @Query("SELECT * FROM artist")
    fun getAllArtists(): LiveData<List<ArtistDto>>
}