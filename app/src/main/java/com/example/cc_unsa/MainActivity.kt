package com.example.cc_unsa

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Space
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cc_unsa.view.activity.HomeActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        startActivity(Intent(this, HomeActivity::class.java));

        //Diseños
        calculateSpaceForBotPannel()
    }

    private fun calculateSpaceForBotPannel() {
        val parent = findViewById<ConstraintLayout>(R.id.main)
        val space = findViewById<Space>(R.id.spaceForBotPannel)

        // Obtener la altura de la vista padre y ajustar la altura de la vista hija
        parent.getViewTreeObserver().addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Remover el listener para evitar múltiples llamadas
                parent.getViewTreeObserver().removeOnGlobalLayoutListener(this)

                val parentHeight: Int = parent.height
                val newChildHeight =
                    (parentHeight - dpToPx(80f) ).toInt()// 50% de la altura de la vista padre

                // Ajustar la altura de la vista hija
                val params: ViewGroup.LayoutParams = space.layoutParams
                params.height = newChildHeight
                space.setLayoutParams(params)
            }
        })


    }
    private fun dpToPx(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
    }
}