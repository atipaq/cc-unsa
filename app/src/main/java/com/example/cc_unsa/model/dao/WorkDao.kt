package com.example.cc_unsa.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cc_unsa.model.entity.WorkEntity

@Dao
interface WorkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWork(work: WorkEntity)

    @Delete
    suspend fun deleteWork(entity: WorkEntity)

    @Query("SELECT * FROM work w WHERE w.id = :id")
    suspend fun getWorkById(id: Int): WorkEntity

    @Query("SELECT * FROM work")
    fun getAllWorks(): LiveData<List<WorkEntity>>
}