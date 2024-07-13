package com.example.cc_unsa.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.entity.GalleryEntity

@Dao
interface GalleryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGallery(gallery: GalleryEntity)

    @Delete
    fun deleteGallery(id: Int)

    @Query("SELECT * FROM gallery g WHERE g.id = :id")
    fun getGalleryById(id: Int): GalleryEntity

    @Query("SELECT * FROM gallery")
    fun getAllGalleries(): List<GalleryEntity>

}