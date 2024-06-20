package com.example.cc_unsa.view

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
        color = Color.rgb(255, 87, 34) // Orange color for galleries
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

    data class Gallery(val x: Float, val y: Float, val label: String)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the red background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        // Draw the white pathways
        canvas.drawRect(150f, 0f, 450f, height.toFloat(), whitePaint)
        canvas.drawRect(0f, 150f, width.toFloat(), 450f, whitePaint)

        // Draw the green squares
        canvas.drawRect(600f, 1350f, 900f, 1650f, greenPaint)
        canvas.drawRect(1200f, 600f, 1500f, 900f, greenPaint)

        // Draw the entrance
        canvas.drawRect(0f, 1200f, 300f, 1500f, entryPaint)

        // Draw galleries and labels
        val galleries = listOf(
            Gallery(900f, 150f, "GALERIA 1"),
            Gallery(1350f, 150f, "GALERIA 2"),
            Gallery(900f, 600f, "GALERIA 3"),
            Gallery(300f, 1050f, "GALERIA 4"),
            Gallery(150f, 1050f, "GALERIA 5"),
            Gallery(1500f, 750f, "GALERIA 6"),
            Gallery(900f, 1500f, "GALERIA 7")
        )

        for (gallery in galleries) {
            canvas.drawOval(RectF(gallery.x, gallery.y, gallery.x + 300f, gallery.y + 300f), galleryPaint)
            canvas.drawText(gallery.label, gallery.x + 150f, gallery.y + 170f, galleryTextPaint)
        }

        // Draw doors
        val doors = listOf(
            Pair(1050f, 300f),
            Pair(1200f, 300f),
            Pair(1050f, 750f),
            Pair(450f, 1050f),
            Pair(300f, 1050f),
            Pair(1350f, 750f),
            Pair(1050f, 1500f)
        )

        for ((x, y) in doors) {
            canvas.drawRect(x, y, x + 100f, y + 50f, doorPaint)
        }
    }
}
