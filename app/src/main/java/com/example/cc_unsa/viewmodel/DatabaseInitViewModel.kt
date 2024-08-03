package com.example.cc_unsa.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cc_unsa.database.AppDatabase
import com.example.cc_unsa.model.entity.ArtistEntity
import com.example.cc_unsa.model.entity.ExhibitionEntity
import com.example.cc_unsa.model.entity.GalleryEntity
import com.example.cc_unsa.model.entity.WorkEntity
import com.example.cc_unsa.repository.ArtistRepository
import com.example.cc_unsa.repository.ExhibitionRepository
import com.example.cc_unsa.repository.GalleryRepository
import com.example.cc_unsa.repository.WorkRepository
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

class DatabaseInitViewModel(application: Application): AndroidViewModel(application) {

    private val artistRepository: ArtistRepository
    private val exhibitionRepository: ExhibitionRepository
    private val galleryRepository: GalleryRepository
    private val workRepository: WorkRepository

    init {
        val dbInstance = AppDatabase.getInstance(application.applicationContext)
        artistRepository = ArtistRepository(dbInstance.artistDao())
        exhibitionRepository = ExhibitionRepository(dbInstance.exhibitionDao())
        galleryRepository = GalleryRepository(dbInstance.galleryDao())
        workRepository = WorkRepository(dbInstance.workDao())
    }

    private fun insertArtist(artist: ArtistEntity) = viewModelScope.launch {
        artistRepository.insertArtist(artist)
    }
    private fun insertExhibition(exhibition: ExhibitionEntity) = viewModelScope.launch {
        exhibitionRepository.insertExhibition(exhibition)
    }
    private fun insertGallery(galleryEntity: GalleryEntity) = viewModelScope.launch {
        galleryRepository.insertGallery(galleryEntity)
    }
    private fun insertWork(workEntity: WorkEntity) = viewModelScope.launch {
        workRepository.insertWork(workEntity)
    }

    fun insertArtistsFromCSV(context: Context, filename: String) {
        val assetManager = context.assets
        try {
            assetManager.open(filename).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line = reader.readLine()
                    while (line != null) {
                        val columns = line.split(",") // Suponiendo que las columnas están separadas por comas
                        // Procesa los datos aquí, por ejemplo:
                        val artistName = columns[0]
                        val artistSpecialty = columns[1]
                        val artistPhoto = columns[2]
                        val artistBiography = columns[3]
                        val artistAwards = columns[4]

                        val artist = ArtistEntity(
                            id = null,
                            name = artistName,
                            specialty = artistSpecialty,
                            photo = artistPhoto,
                            biography = artistBiography,
                            awards = artistAwards
                        )
                        this.insertArtist(artist)
                        line = reader.readLine()
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Maneja el error apropiadamente
        }
    }

    fun insertExhibitionsFromCSV(context: Context, filename: String) {
        val assetManager = context.assets
        try {
            assetManager.open(filename).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line = reader.readLine()
                    while (line != null) {
                        val columns = line.split(",") // Suponiendo que las columnas están separadas por comas
                        // Procesa los datos aquí, por ejemplo:
                        val name = columns[0]
                        val galleryId = columns[1]
                        val artistId = columns[2]
                        val period = columns[3]
                        val descriptionText = columns[4]
                        val descriptionAudio = columns[5]
                        val state = columns[6]

                        val exhibition = ExhibitionEntity(
                            id = null,
                            name = name,
                            galleryId = galleryId.toInt(),
                            artistId = artistId.toInt(),
                            period = period.toInt(),
                            descriptionText = descriptionText,
                            descriotionAudio = descriptionAudio,
                            state = state.toBoolean()
                        )
                        this.insertExhibition(exhibition)
                        line = reader.readLine()
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Maneja el error apropiadamente
        }
    }

    fun insertGalleriesFromCSV(context: Context, filename: String) {
        val assetManager = context.assets
        try {
            assetManager.open(filename).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line = reader.readLine()
                    while (line != null) {
                        val columns = line.split(",") // Suponiendo que las columnas están separadas por comas
                        // Procesa los datos aquí, por ejemplo:
                        val name = columns[0]
                        val description = columns[1]

                        val gallery = GalleryEntity(
                            id = null,
                            name = name,
                            description = description
                        )
                        this.insertGallery(gallery)
                        line = reader.readLine()
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Maneja el error apropiadamente
        }
    }

    fun insertWorksFromCSV(context: Context, filename: String) {
        val assetManager = context.assets
        try {
            assetManager.open(filename).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    var line = reader.readLine()
                    while (line != null) {
                        val columns = line.split(",") // Suponiendo que las columnas están separadas por comas
                        // Procesa los datos aquí, por ejemplo:
                        val title = columns[0]
                        val exhibitionId = columns[1]
                        val artistId = columns[2]
                        val technique = columns[3]
                        val description = columns[4]
                        val dimension = columns[5]
                        val year = columns[6]
                        val image = columns[7]
                        val positionX = columns[8]
                        val positionY = columns[9]

                        val work = WorkEntity(
                            id = null,
                            title = title,
                            exhibitionId = exhibitionId.toInt(),
                            artistId = artistId.toInt(),
                            technique = technique,
                            description = description,
                            dimension = dimension,
                            year = year.toInt(),
                            image = image,
                            positionX = positionX.toFloat(),
                            positionY = positionY.toFloat()
                        )
                        this.insertWork(work)
                        line = reader.readLine()
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace() // Maneja el error apropiadamente
        }
    }
}