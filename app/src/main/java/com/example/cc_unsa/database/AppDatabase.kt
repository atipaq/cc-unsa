package com.example.cc_unsa.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cc_unsa.model.dao.ArtistDao
import com.example.cc_unsa.model.dao.GalleryDao
import com.example.cc_unsa.model.dao.PictureDao
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.model.entity.GalleryEntity
import com.example.cc_unsa.model.entity.PictureEntity


@Database(entities = [
    GalleryEntity::class,
    PictureEntity::class,
    ArtistEntity::class
                     ], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun galleryDao(): GalleryDao
    abstract fun pictureDao(): PictureDao
    abstract fun artistDao(): ArtistDao
}