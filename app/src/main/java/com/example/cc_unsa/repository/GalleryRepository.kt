package com.example.cc_unsa.repository

import com.example.cc_unsa.model.dao.GalleryDao
import com.example.cc_unsa.model.entity.GalleryEntity

class GalleryRepository (
    private val galleryDao: GalleryDao
){
    suspend fun insertGallery(gallery: GalleryEntity) {
        galleryDao.insertGallery(gallery)
    }
}