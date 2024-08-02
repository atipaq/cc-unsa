package com.example.cc_unsa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cc_unsa.database.AppDatabase
import com.example.cc_unsa.repository.ExhibitionRepository
import com.example.cc_unsa.repository.WorkRepository

class GalleryInfoViewModel(application: Application): AndroidViewModel(application) {
    private val exhibitionRepository: ExhibitionRepository
    private val workRepository: WorkRepository

    init {
        val dbInstance = AppDatabase.getInstance(application.applicationContext)
        exhibitionRepository = ExhibitionRepository(dbInstance.exhibitionDao())
        workRepository = WorkRepository(dbInstance.workDao())
    }
    suspend fun getExhibitionById(exhibitionId: Int) = exhibitionRepository.getExhibitionInfoById(exhibitionId)
    suspend fun getWorksByExhibitionId(exhibitionId: Int) = workRepository.getWorksInGalleryByExhibitionId(exhibitionId)
}