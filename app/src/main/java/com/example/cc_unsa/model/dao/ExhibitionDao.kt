package com.example.cc_unsa.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.entity.ExhibitionEntity

@Dao
interface ExhibitionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExhibition(exhibition: ExhibitionEntity)

    @Delete
    suspend fun deleteExhibition(entity: ExhibitionEntity)

    @Query("SELECT * FROM exhibition e WHERE e.id = :id")
    suspend fun getExhibitionById(id: Int): ExhibitionEntity

    @Query("SELECT * FROM exhibition")
    fun getAllExhibitions(): LiveData<List<ExhibitionEntity>>
}