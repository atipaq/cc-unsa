package com.example.cc_unsa.repository

import androidx.lifecycle.LiveData
import com.example.cc_unsa.model.dao.ExhibitionDao
import com.example.cc_unsa.model.entity.ExhibitionEntity

class ExhibitionRepository(
    private val exhibitionDao: ExhibitionDao
) {
    suspend fun insertExhibition(exhibition: ExhibitionEntity) {
        exhibitionDao.insertExhibition(exhibition)
    }
}