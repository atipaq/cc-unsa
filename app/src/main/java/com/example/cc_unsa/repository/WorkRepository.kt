package com.example.cc_unsa.repository

import com.example.cc_unsa.model.dao.WorkDao
import com.example.cc_unsa.model.entity.WorkEntity

class WorkRepository(
    private val workDao: WorkDao
) {

    suspend fun insertWork(work: WorkEntity) {
        workDao.insertWork(work)
    }

    suspend fun getWorksByExhibitionId(exhibitionId: Int) = workDao.getWorkByExhibitionId(exhibitionId)
}