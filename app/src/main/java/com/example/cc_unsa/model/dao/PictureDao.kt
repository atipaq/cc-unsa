package com.example.cc_unsa.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.entity.PictureEntity

@Dao
interface PictureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture: PictureEntity)

    @Delete
    fun deletePicture(id: Int)

    @Query("SELECT * FROM picture p WHERE p.id = :id")
    fun getPictureById(id: Int): PictureEntity

    @Query("SELECT * FROM picture")
    fun getAllPictures(): List<PictureEntity>
}