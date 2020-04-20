package com.sun.android.sample.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.sun.android.util.dp2px
import java.util.jar.Attributes

/**
 *
 * @author tianxiaolong
 * time：2020/4/20 10:45 PM
 * description：
 */

class DashboardView @JvmOverloads constructor(context:Context,attr: AttributeSet?=null):View(context,attr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).also {
        it.color = Color.RED
        it.pathEffect
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(150f.dp2px(),150f.dp2px(),100f.dp2px(),paint)
    }

}