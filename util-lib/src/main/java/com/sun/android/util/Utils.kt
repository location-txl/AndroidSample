package com.sun.android.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.provider.Settings
import android.util.TypedValue
import java.lang.reflect.TypeVariable

/**
 *
 * @author tianxiaolong
 * time：2019/12/2 19:24
 * description：
 */

inline fun <reified T : Activity> Context.startUiActivity(noinline block: (Intent.() -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    block?.let { it(intent) }
    startActivity(intent)
}

fun Float.dp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

fun Float.sp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)



