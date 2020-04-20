package com.sun.android.util

import android.app.Activity
import android.os.Bundle

/**
 *
 * @author tianxiaolong
 * time：2020/4/20 10:33 PM
 * description：
 */
class TestActivity :Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startUiActivity<TestActivity>{
            putExtra("s","s")
            putExtra("a","a")
            putExtra("b","b")
        }
    }
}