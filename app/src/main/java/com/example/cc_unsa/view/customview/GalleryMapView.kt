package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Shader
import android.view.View
import com.example.cc_unsa.viewmodel.dto.WorkDto
import java.io.IOException

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
    private val paint = Paint().apply {
        isAntiAlias = true
    }
    private fun drawCircularImage(canvas: Canvas,filename: String, x: Float, y: Float, radius: Float) {
        try {
            val inputStream = context.assets.open("pinturas/$filename")
            val bitmapSrc = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(inputStream), 100, 100, false)
            inputStream.close()
            val shader = BitmapShader(bitmapSrc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = shader

            val circleBitmap = Bitmap.createBitmap(radius.toInt() * 2, radius.toInt() * 2, Bitmap.Config.ARGB_8888)
            val canvasCircle = Canvas(circleBitmap)
            canvasCircle.drawCircle(radius, radius, radius, paint)

            canvas.drawBitmap(circleBitmap, x - radius, y - radius, null)

        } catch (e: IOException) {
            throw RuntimeException(e)
        }
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

        //Dibujar obras
        works.forEach {
            drawCircularImage(canvas, it.image, wu*it.positionX, hu*it.positionY, 50f)
        }
    }
}