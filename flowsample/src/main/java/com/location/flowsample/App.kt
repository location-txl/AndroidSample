package com.location.flowsample

import android.app.Application
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 *
 * @author tianxiaolong
 * time：2022/6/24 16:37
 * description：
 */
class App :Application(){
    private var count = 0
    private val _testShareFlow:MutableStateFlow<Int> = MutableStateFlow(count)
    val testStateFlow = _testShareFlow.asSharedFlow()

    fun add(){
        count++
        _testShareFlow.tryEmit(count)
    }
    companion object
    {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}