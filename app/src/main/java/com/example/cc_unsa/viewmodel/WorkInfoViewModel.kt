package com.example.cc_unsa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cc_unsa.database.AppDatabase
import com.example.cc_unsa.repository.WorkRepository

class WorkInfoViewModel(application: Application):AndroidViewModel(application) {
    private val workRepository: WorkRepository

    init {
        val dbInstance = AppDatabase.getInstance(application.applicationContext)
        workRepository = WorkRepository(dbInstance.workDao())
    }
    suspend fun getWorkById(id: Int) = workRepository.getWorkById(id)
}