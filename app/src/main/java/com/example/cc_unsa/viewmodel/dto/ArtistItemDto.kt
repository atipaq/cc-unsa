package com.example.cc_unsa.viewmodel.dto

import androidx.room.Ignore

data class ArtistItemDto(
    val id: Int,
    val name: String,
    val specialty: String,
    val photo: String
): ItemCarouselDtoInterface
{
    @Ignore override fun id(): Int{
        return id
    }
    @Ignore override fun name(): String{
        return name
    }
    @Ignore override fun specialty(): String{
        return specialty
    }
    @Ignore override fun photo(): String{
        return photo
    }
}
