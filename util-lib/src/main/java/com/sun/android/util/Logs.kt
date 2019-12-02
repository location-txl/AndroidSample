package com.sun.android.util

import android.util.Log

/**
 *
 * @author tianxiaolong
 * time：2019/12/2 15:18
 * description：
 */
object Logs {

    const val TAG = "[Log]"
    // 1 << 1
    const val LOG_INFO = 1.shl(1)
    const val LOG_DEBUG = 1.shl(2)
    const val LOG_ERROR = 1.shl(3)
    const val LOG_ALL = LOG_INFO or LOG_DEBUG or LOG_ERROR

    var LOG_LEVE = LOG_ALL

    // LOG_INFO | LOG_DEBUG | LOG_ERROR
    private fun debug(level: Int) = LOG_LEVE.and(level) == level

    @JvmOverloads
    fun I(msg: String, tag: String = TAG) {
        if (debug(LOG_INFO)) Log.i(tag,msg)
    }

    @JvmOverloads
    fun D(msg: String, tag: String = TAG) {
        if (debug(LOG_DEBUG)) Log.d(tag, formatString(tag,msg))
    }

    private  fun formatString(tag:String,msg:String) = if(tag == TAG) "[$msg]" else msg



}