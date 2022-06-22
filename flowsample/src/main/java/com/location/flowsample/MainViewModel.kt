package com.location.flowsample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @author tianxiaolong
 * time：2022/6/9 14:53
 * description：
 */
class MainViewModel : ViewModel() {

    private val _stateFlow:MutableStateFlow<String> = MutableStateFlow("init data");
    val stateFlow:StateFlow<String> = _stateFlow.asStateFlow()

    private val _shareFlow:MutableSharedFlow<String> = MutableSharedFlow(replay = 1, extraBufferCapacity = 2, onBufferOverflow = BufferOverflow.SUSPEND)

    val shareFlow:SharedFlow<String> = _shareFlow.asSharedFlow()


    private var stateFlowCount = 0
    private var shareFlowCount = 0

    fun dataChange(){
        viewModelScope
            .launch {
                withContext(Dispatchers.IO){
                    _stateFlow.emit("hello${stateFlowCount++}")
                }
            }
    }

    fun shareFlowSend(){
        viewModelScope.launch {
//            for (x in 1..99){
                Log.i("txlTest","start send shareflow Count")
                shareFlowCount++
                _shareFlow.emit("toast${shareFlowCount}")
                Log.i("txlTest","end send shareflow Count:$shareFlowCount")
//            }

        }
    }

}