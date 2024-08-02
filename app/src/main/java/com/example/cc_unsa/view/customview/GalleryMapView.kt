package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.example.cc_unsa.viewmodel.dto.ExhibitionDto
import com.example.cc_unsa.viewmodel.dto.WorkDto
import com.example.cc_unsa.viewmodel.dto.WorkInGalleryDto

class GalleryMapView(
    context: Context,
    private val exhibitionName: String,
    private val works:List<WorkDto>
): View(context) {

    private val whitePaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }
    private val yellowPaint = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
    }

    private val textPaint = Paint().apply {
        color = Color.DKGRAY
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val wu = width.toFloat()/24f
        val hu = height.toFloat()/33f

        //Dibujar camino blanco
        canvas.drawRect(wu*2f,hu*1f,wu*23f,hu*32f,whitePaint)

        //Dibujar puerta
        canvas.drawRect(wu*.5f,hu*13f,wu*2.5f,hu*20f,yellowPaint)

        //Dibujar texto nombre de galeria
        canvas.drawText(exhibitionName, wu*12f, hu*16f, textPaint)
    }
}