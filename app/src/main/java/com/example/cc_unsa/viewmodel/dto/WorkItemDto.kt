package com.example.cc_unsa.viewmodel.dto

import androidx.room.Ignore

data class WorkItemDto(
    val id: Int,
    val title:String,
    val technique: String,
    val dimension: String,
    val image: String
): ItemCarouselDtoInterface
{
    @Ignore
    override fun id(): Int{
        return id
    }
    @Ignore override fun title(): String{
        return title
    }
    @Ignore override fun technique(): String{
        return technique
    }
    @Ignore override fun dimension(): String{
        return dimension
    }
    @Ignore override fun image(): String{
        return image
    }
}
