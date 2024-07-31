package com.example.cc_unsa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cc_unsa.database.AppDatabase
import com.example.cc_unsa.repository.CarouselItemRepository
import com.example.cc_unsa.viewmodel.dto.ArtistItemDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionItemDto
import com.example.cc_unsa.viewmodel.dto.WorkItemDto

class CarouselViewModel(application: Application): AndroidViewModel(application) {
    private val repository: CarouselItemRepository
    val allArtists: LiveData<List<ArtistItemDto>>
    val allWorks: LiveData<List<WorkItemDto>>
    val allExhibitions: LiveData<List<ExhibitionItemDto>>

    init {
        val carouselDao = AppDatabase.getInstance(application).carouselDao()
        repository = CarouselItemRepository(carouselDao)
        allArtists = repository.allArtists
        allWorks = repository.allWorks
        allExhibitions = repository.allExhibitions
    }

}