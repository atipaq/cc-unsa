package com.example.cc_unsa.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.dto.ArtistItemDto
import com.example.cc_unsa.model.entity.ArtistEntity

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtist(artist: ArtistEntity)

    @Delete
    fun deleteArtist(id: Int)

    @Query("SELECT * FROM artist a WHERE a.id = :id")
    fun getArtistById(id: Int): ArtistEntity

    @Query("SELECT a.id, a.name, a.lastname, a.specialty, a.photo FROM artist a WHERE a.id = :id")
    fun getArtistItemById(id: Int): ArtistItemDto

    @Query("SELECT * FROM artist")
    fun getAllArtists(): List<ArtistEntity>
}