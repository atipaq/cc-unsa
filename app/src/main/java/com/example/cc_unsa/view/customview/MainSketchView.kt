package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class MainSketchView(context: Context?) : View(context) {
    private val backgroundPaint = Paint().apply {
        //set hexademical color: #F13A21
        color = Color.rgb(190,1,39)
        style = Paint.Style.FILL
    }

    private val galleryPaint = Paint().apply {
        color = Color.rgb(241, 58, 33) // Orange color for galleries
        style = Paint.Style.FILL
    }

    private val galleryTextPaint = Paint().apply {
        color = Color.WHITE
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }

    private val entryPaint = Paint().apply {
        color = Color.CYAN
        style = Paint.Style.FILL
    }

    private val doorPaint = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
    }

    private val whitePaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }

    private val greenPaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
    }

    private val sshhPaint = Paint().apply {
        color = Color.rgb(11, 246, 232) // Orange color for galleries
        style = Paint.Style.FILL
    }

    data class Gallery(val x: Float, val y: Float, val label: String)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val wu = width.toFloat()/24f
        val hu = height.toFloat()/50f

        // Draw the red background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        //Draw the entry text
        canvas.drawText("ENTRADA", wu*8.5f, hu*2f, galleryTextPaint)

        // Draw gallery circles
        canvas.drawCircle(wu*16f, hu*7.5f, wu*2.5f, galleryPaint) // Gallery 1
        canvas.drawText("GALERIA", wu*16f, hu*7.5f, galleryTextPaint)
        canvas.drawText("1", wu*16f, hu*7.5f+40f, galleryTextPaint)

        canvas.drawCircle(wu*22f, hu*14.5f, wu*2.5f, galleryPaint) // Gallery 2
        canvas.drawText("GALERIA", wu*22f, hu*14.5f, galleryTextPaint)
        canvas.drawText("2", wu*22f, hu*14.5f+40f, galleryTextPaint)

        canvas.drawCircle(wu*16f, hu*21.5f, wu*2.5f, galleryPaint) // Gallery 3
        canvas.drawText("GALERIA", wu*16f, hu*21.5f, galleryTextPaint)
        canvas.drawText("3", wu*16f, hu*21.5f+40f, galleryTextPaint)

        canvas.drawCircle(wu*4f, hu*14.5f, wu*2.5f, galleryPaint) // Gallery 4
        canvas.drawText("GALERIA", wu*4f, hu*14.5f, galleryTextPaint)
        canvas.drawText("4", wu*4f, hu*14.5f+40f, galleryTextPaint)

        canvas.drawCircle(wu*4f, hu*22.5f, wu*2.5f, galleryPaint) // Gallery 5
        canvas.drawText("GALERIA", wu*4f, hu*22.5f, galleryTextPaint)
        canvas.drawText("5", wu*4f, hu*22.5f+40f, galleryTextPaint)

        canvas.drawCircle(wu*22f, hu*34f, wu*2.5f, galleryPaint) // Gallery 6
        canvas.drawText("GALERIA", wu*22f, hu*34f, galleryTextPaint)
        canvas.drawText("6", wu*22f, hu*34f+40f, galleryTextPaint)

        canvas.drawCircle(wu*16f, hu*39f, wu*2.5f, galleryPaint) // Gallery 7
        canvas.drawText("GALERIA", wu*16f, hu*39f, galleryTextPaint)
        canvas.drawText("7", wu*16f, hu*39f+40f, galleryTextPaint)

        // Draw the white pathways
        canvas.drawRect(wu*5.5f,hu*3.5f,wu*11.5f,hu*43,whitePaint)
        canvas.drawRect(wu*11.5f,hu*9.5f,wu*19.5f,hu*20f,whitePaint)
        canvas.drawRect(wu*11.5f,hu*26.5f,wu*20.5f,hu*37.5f,whitePaint)
        canvas.drawRect(wu*4.5f,hu*43f,wu*20f,hu*49f,whitePaint)

        // Draw the green squares
        canvas.drawRect(wu*14f,hu*31f,wu*19f,hu*36.5f,greenPaint)
        canvas.drawRect(wu*14f,hu*45f,wu*17f,hu*48f,greenPaint)

        // Draw the SSHH
        canvas.drawRect(wu,hu*42.5f,wu*4.5f,hu*49f,sshhPaint)


    }
}
