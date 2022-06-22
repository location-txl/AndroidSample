package com.location.flowsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.location.flowsample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit var mainBinding:ActivityMainBinding
    private var isRegist = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        lifecycleScope.launch {
            viewModel.stateFlow
                .flowWithLifecycle(lifecycle = lifecycle)
                .collect {
                    mainBinding.stateFlowText.text = it
                }
        }
        mainBinding.stateFlowBtn.setOnClickListener {
            viewModel.dataChange()
        }

        mainBinding.shareFlowBtn.setOnClickListener {
            viewModel.shareFlowSend()
        }
        mainBinding.registerShareFlowBtn.setOnClickListener {
            if(isRegist){
                return@setOnClickListener
            }
            isRegist = true
            lifecycleScope.launch {
                viewModel.shareFlow
                    .flowWithLifecycle(lifecycle)
                    .collect {
                        Log.i("txlTest","recive collect start")
                        delay(2000)
                        Log.i("txlTest","recive collect end data:$it")
                    }
            }
        }
    }
}