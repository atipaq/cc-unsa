package com.example.cc_unsa.repository

import androidx.lifecycle.LiveData
import com.example.cc_unsa.model.dao.ExhibitionDao
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.viewmodel.dto.ExhibitionDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionInfoInMapDto

class ExhibitionRepository(
    private val exhibitionDao: ExhibitionDao
) {
    suspend fun insertExhibition(exhibition: ExhibitionEntity) {
        exhibitionDao.insertExhibition(exhibition)
    }
    suspend fun getExhibitionInfoById(exhibitionId: Int): ExhibitionInfoInMapDto {
        return exhibitionDao.getExhibitionInfoById(exhibitionId)
    }
}