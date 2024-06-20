package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class CustomMapView(context: Context) : View(context) {
    private val paint = Paint()
    private val path = Path()
    private val textPaint = Paint()


    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 15f

        textPaint.color = Color.BLACK  // Puedes cambiar el color del texto si lo deseas
        textPaint.textSize = 40f  // Tamaño del texto
        textPaint.textAlign = Paint.Align.CENTER  // Alinear el texto al centro

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Obtener dimensiones de la vista
        val viewWidth = width.toFloat()
        val viewHeight = height.toFloat()

        // Dibujar cada habitación y pasillo utilizando Path y coordenadas relativas
        gallery4a(canvas, viewWidth, viewHeight)
        gallery4b(canvas, viewWidth, viewHeight)
        notUseful(canvas, viewWidth, viewHeight)
        toilets(canvas, viewWidth, viewHeight)
        gallery5(canvas, viewWidth, viewHeight)
        gallery1a(canvas, viewWidth, viewHeight)
        gallery1b(canvas, viewWidth, viewHeight)
        gallery2a(canvas, viewWidth, viewHeight)
        gallery2b(canvas, viewWidth, viewHeight)
        gallery3(canvas, viewWidth, viewHeight)
        gallery6(canvas, viewWidth, viewHeight)
        lounge(canvas, viewWidth, viewHeight)
        // Agregar más llamadas a funciones para dibujar otras habitaciones y pasillos
    }

    private fun gallery4a(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación A (ejemplo de coordenadas relativas)
        val left = 0.0f * viewWidth
        val top = 0.0f * viewHeight
        val right = 0.26f * viewWidth
        val bottom = 0.12f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)

        // Dibujar el texto en el centro del recuadro
        val centerX = (left + right) / 2
        val centerY = (top + bottom) / 2 - ((textPaint.descent() + textPaint.ascent()) / 2)
        canvas.drawText("GALERIA 4", centerX, centerY, textPaint)

    }

    private fun gallery4b(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación A (ejemplo de coordenadas relativas)
        val left = 0.0f * viewWidth
        val top = 0.12f * viewHeight
        val right = 0.26f * viewWidth
        val bottom = 0.30f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery5(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación A (ejemplo de coordenadas relativas)
        val left = 0.0f * viewWidth
        val top = 0.30f * viewHeight
        val right = 0.26f * viewWidth
        val bottom = 0.56f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun notUseful(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación A (ejemplo de coordenadas relativas)
        val left = 0.0f * viewWidth
        val top = 0.56f * viewHeight
        val right = 0.26f * viewWidth
        val bottom = 0.84f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun toilets(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación A (ejemplo de coordenadas relativas)
        val left = 0.0f * viewWidth
        val top = 0.84f * viewHeight
        val right = 0.24f * viewWidth
        val bottom = 1f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery1a(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.34f * viewWidth
        val top = 0.0f * viewHeight
        val right = 0.70f * viewWidth
        val bottom = 0.14f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery1b(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.70f * viewWidth
        val top = 0.0f * viewHeight
        val right = 1f * viewWidth
        val bottom = 0.18f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery2a(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.70f * viewWidth
        val top = 0.18f * viewHeight
        val right = 1f * viewWidth
        val bottom = 0.46f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery2b(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.70f * viewWidth
        val top = 0.46f * viewHeight
        val right = 1f * viewWidth
        val bottom = 0.56f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery3(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.36f * viewWidth
        val top = 0.46f * viewHeight
        val right = 0.70f * viewWidth
        val bottom = 0.56f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun gallery6(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.70f * viewWidth
        val top = 0.60f * viewHeight
        val right = 1f * viewWidth
        val bottom = 0.84f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }

    private fun lounge(canvas: Canvas, viewWidth: Float, viewHeight: Float) {
        path.reset()
        // Definir los vértices de la habitación B (ejemplo de coordenadas relativas)
        val left = 0.36f * viewWidth
        val top = 0.70f * viewHeight
        val right = 0.70f * viewWidth
        val bottom = 0.84f * viewHeight

        path.moveTo(left, top)
        path.lineTo(right, top)
        path.lineTo(right, bottom)
        path.lineTo(left, bottom)
        path.close()

        canvas.drawPath(path, paint)
    }


}