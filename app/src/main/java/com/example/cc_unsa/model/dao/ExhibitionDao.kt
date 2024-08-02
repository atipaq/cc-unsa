package com.example.cc_unsa.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.viewmodel.dto.ExhibitionDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionInfoInMapDto

@Dao
interface ExhibitionDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertExhibition(exhibition: ExhibitionEntity)

    @Delete
    suspend fun deleteExhibition(entity: ExhibitionEntity)

    @Query("SELECT * FROM exhibition e WHERE e.id = :id")
    suspend fun getExhibitionById(id: Int): ExhibitionDto

    @Query("SELECT  e.id, e.name, g.name as galleryName,a.name as artistName, e.period, e.descriptionText, e.descriotionAudio, e.state FROM exhibition e INNER JOIN gallery g ON e.galleryId = g.id INNER JOIN artist a ON e.artistId = a.id WHERE g.id = :id")
    suspend fun getExhibitionInfoById(id: Int): ExhibitionInfoInMapDto

    @Query("SELECT * FROM exhibition")
    fun getAllExhibitions(): LiveData<List<ExhibitionEntity>>
}