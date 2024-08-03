package com.example.cc_unsa.repository

import androidx.lifecycle.LiveData
import com.example.cc_unsa.model.dao.CarouselDao
import com.example.cc_unsa.viewmodel.dto.ArtistItemDto
import com.example.cc_unsa.viewmodel.dto.ExhibitionItemDto
import com.example.cc_unsa.viewmodel.dto.WorkItemDto

class CarouselItemRepository(
    private val carouselDao: CarouselDao,
) {
    val allArtists: LiveData<List<ArtistItemDto>> = carouselDao.getAllArtist()
    val allWorks: LiveData<List<WorkItemDto>> = carouselDao.getAllWorks()
    val allExhibitions: LiveData<List<ExhibitionItemDto>> = carouselDao.getAllExhibition()


}