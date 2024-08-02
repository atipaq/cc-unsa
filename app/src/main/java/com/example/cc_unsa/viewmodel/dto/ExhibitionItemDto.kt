package com.example.cc_unsa.viewmodel.dto

import androidx.room.Ignore

data class ExhibitionItemDto(
    val id: Int,
    val image: String,
    val artistName: String,
    val period: String,
    val name: String
): ItemCarouselDtoInterface
{
    @Ignore override fun id(): Int{
        return id
    }
    @Ignore override fun image(): String{
        return image
    }
    @Ignore override fun name(): String{
        return name
    }
    @Ignore override fun artistName(): String{
        return artistName
    }
    @Ignore override fun period(): String{
        return period
    }
}
