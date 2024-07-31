package com.example.cc_unsa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cc_unsa.model.dao.ArtistDao
import com.example.cc_unsa.model.dao.CarouselDao
import com.example.cc_unsa.model.dao.ExhibitionDao
import com.example.cc_unsa.model.dao.GalleryDao
import com.example.cc_unsa.model.dao.WorkDao
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.model.entity.GalleryEntity
import com.example.cc_unsa.model.entity.WorkEntity


@Database(entities = [
    GalleryEntity::class,
    WorkEntity::class,
    ArtistEntity::class,
    ExhibitionEntity::class
                     ], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun workDao(): WorkDao
    abstract fun exhibitionDao(): ExhibitionDao
    abstract fun galleryDao(): GalleryDao
    abstract fun artistDao(): ArtistDao
    abstract fun carouselDao(): CarouselDao

    companion object {
        private const val DATABASE_NAME = "cc_unsa_db"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}