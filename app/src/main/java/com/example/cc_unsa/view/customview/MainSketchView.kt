package com.example.cc_unsa.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.cc_unsa.view.fragment.FragmentListener
import java.util.jar.Attributes

class MainSketchView(
    context: Context?,
    attrs:AttributeSet? = null,
    defStyleAttr:Int = 0
) : View(context, attrs, defStyleAttr) {

    private var fragmentChangeListener: FragmentListener? = null
    init {
        if(context is FragmentListener) {
            fragmentChangeListener = context
        }
    }
    private val salasPosition = listOf(
        Pair(8.5f, 42f),
        Pair(3f, 35f),
        Pair(9f, 28f),
        Pair(20.5f, 34.5f),
        Pair(20.5f, 27f),
        Pair(2.5f, 16f),
        Pair(9f, 10f)
    )
    private var galleryClicked:Int = 0
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
        textSize = 25f
        textAlign = Paint.Align.CENTER
    }
    private val entryTextPaint = Paint().apply {
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
    private fun isInsideCircle(touchX: Float, touchY: Float, centerX: Float, centerY: Float, radius: Float): Boolean {
        val dx = touchX - centerX
        val dy = touchY - centerY
        return dx * dx + dy * dy <= radius * radius
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                for (pos in salasPosition) {
                    if (isInsideCircle(event.x, event.y, width.toFloat()/24f*pos.first, height.toFloat()/50f*pos.second, 100f)) {
                        galleryClicked = salasPosition.indexOf(pos) + 1
                        performClick()
                        return true
                    }
                }

            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        fragmentChangeListener?.replaceFragment(galleryClicked)
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val wu = width.toFloat()/24f
        val hu = height.toFloat()/50f

        // Draw the red background
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        //Draw the entry text
        canvas.drawText("ENTRADA", wu*16f, hu*48f, entryTextPaint)

        // Draw gallery circles
        canvas.drawCircle(wu*8.5f, hu*42f, wu*2.5f, galleryPaint) // Gallery 1
        canvas.drawText("GALERIA", wu*8.5f, hu*42f, galleryTextPaint)
        canvas.drawText("1", wu*8.5f, hu*42f+30f, galleryTextPaint)

        canvas.drawCircle(wu*3f, hu*35f, wu*2.5f, galleryPaint) // Gallery 2
        canvas.drawText("GALERIA", wu*3f, hu*35f, galleryTextPaint)
        canvas.drawText("2", wu*3f, hu*35f+30f, galleryTextPaint)

        canvas.drawCircle(wu*9f, hu*28f, wu*2.5f, galleryPaint) // Gallery 3
        canvas.drawText("GALERIA", wu*9f, hu*28f, galleryTextPaint)
        canvas.drawText("3", wu*9f, hu*28f+30f, galleryTextPaint)

        canvas.drawCircle(wu*20.5f, hu*34.5f, wu*2.5f, galleryPaint) // Gallery 4
        canvas.drawText("GALERIA", wu*20.5f, hu*34.5f, galleryTextPaint)
        canvas.drawText("4", wu*20.5f, hu*34.5f+30f, galleryTextPaint)

        canvas.drawCircle(wu*20.5f, hu*27f, wu*2.5f, galleryPaint) // Gallery 5
        canvas.drawText("GALERIA", wu*20.5f, hu*27f, galleryTextPaint)
        canvas.drawText("5", wu*20.5f, hu*27f+30f, galleryTextPaint)

        canvas.drawCircle(wu*2.5f, hu*16f, wu*2.5f, galleryPaint) // Gallery 6
        canvas.drawText("GALERIA", wu*2.5f, hu*16f, galleryTextPaint)
        canvas.drawText("6", wu*2.5f, hu*16f+30f, galleryTextPaint)

        canvas.drawCircle(wu*9f, hu*10f, wu*2.5f, galleryPaint) // Gallery 7
        canvas.drawText("GALERIA", wu*9f, hu*10f, galleryTextPaint)
        canvas.drawText("7", wu*9f, hu*10f+30f, galleryTextPaint)

        // Draw the white pathways
        canvas.drawRect(wu*13f,hu*7f,wu*19f,hu*46,whitePaint)
        canvas.drawRect(wu*5f,hu*29.5f,wu*13.5f,hu*40f,whitePaint)
        canvas.drawRect(wu*4f,hu*12f,wu*13.5f,hu*23f,whitePaint)
        canvas.drawRect(wu*5f,hu*.5f,wu*20.5f,hu*7f,whitePaint)

        // Draw the green squares
        canvas.drawRect(wu*7.5f,hu*2f,wu*11f,hu*5.5f,greenPaint)
        canvas.drawRect(wu*6f,hu*14f,wu*10.5f,hu*18.5f,greenPaint)

        // Draw the SSHH
        canvas.drawRect(wu*20f,hu*.3f,wu*22f,hu*7f,sshhPaint)

    }
}
