package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.cc_unsa.view.fragment.FragmentListener
import com.example.cc_unsa.viewmodel.dto.WorkDto
import com.example.cc_unsa.viewmodel.dto.WorkInGalleryDto
import java.io.IOException

class GalleryMapView(
    context: Context?,

    private val exhibitionName: String,
    private val works:List<WorkInGalleryDto>
): View(context) {
    private var fragmentChangeListener: FragmentListener? = null
    init {
        if(context is FragmentListener) {
            fragmentChangeListener = context
        }
    }
    private var workClicked:Int = 0

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
    private val borderPaint = Paint().apply {
        isAntiAlias = true
        color = Color.DKGRAY
        style = Paint.Style.STROKE
        strokeWidth = 2f
    }
    private fun createHexagonPath(radius: Float): Path {
        val hexagonPath = Path()
        val triangleHeight = (Math.sqrt(3.0) * radius / 2).toFloat()
        hexagonPath.moveTo(radius, 0f)
        hexagonPath.lineTo(radius + triangleHeight, radius / 2)
        hexagonPath.lineTo(radius + triangleHeight, radius * 1.5f)
        hexagonPath.lineTo(radius, radius * 2)
        hexagonPath.lineTo(radius - triangleHeight, radius * 1.5f)
        hexagonPath.lineTo(radius - triangleHeight, radius / 2)
        hexagonPath.close()
        return hexagonPath
    }
    private fun createHexagonPath(x: Float, y: Float, radius: Float): Path {
        val hexagonPath = Path()
        val triangleHeight = (Math.sqrt(3.0) * radius / 2).toFloat()
        hexagonPath.moveTo(x, y - radius)
        hexagonPath.lineTo(x + triangleHeight, y - radius / 2)
        hexagonPath.lineTo(x + triangleHeight, y + radius / 2)
        hexagonPath.lineTo(x, y + radius)
        hexagonPath.lineTo(x - triangleHeight, y + radius / 2)
        hexagonPath.lineTo(x - triangleHeight, y - radius / 2)
        hexagonPath.close()
        return hexagonPath
    }
    private fun drawHexagonalImage(canvas: Canvas, filename: String, x: Float, y: Float, radius: Float) {
        try {
            val inputStream = context.assets.open("pinturas/$filename")
            val bitmapSrc = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(inputStream), 200, 200, false)
            inputStream.close()

            val hexagonPath = createHexagonPath(radius)
             // Increase radius for border

            val hexagonBitmap = Bitmap.createBitmap((radius * 2).toInt(), (radius * 2).toInt(), Bitmap.Config.ARGB_8888)
            val canvasHexagon = Canvas(hexagonBitmap)

            val shader = BitmapShader(bitmapSrc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = shader
            // Draw the border first

            canvasHexagon.drawPath(hexagonPath, paint)

            canvas.drawBitmap(hexagonBitmap, x - radius, y - radius, null)

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
            drawHexagonalImage(canvas, it.image, wu*it.positionX, hu*it.positionY, 50f)
            val hexagonPathWithBorder = createHexagonPath(wu*it.positionX, hu*it.positionY, 50f)
            canvas.drawPath(hexagonPathWithBorder, borderPaint)
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                for (work in works) {
                    if (isInsideCircle(event.x, event.y, width.toFloat()/24f*work.positionX, height.toFloat()/33f*work.positionY, 50f)) {
                        workClicked = works.indexOf(work) + 1
                        performClick()
                        return true
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
    private fun isInsideCircle(touchX: Float, touchY: Float, centerX: Float, centerY: Float, radius: Float): Boolean {
        val dx = touchX - centerX
        val dy = touchY - centerY
        return dx * dx + dy * dy <= radius * radius
    }
    override fun performClick(): Boolean {
        if (super.performClick()) return true
        fragmentChangeListener?.replaceToWorkFragment(workClicked)
        return true
    }
}