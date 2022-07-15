package com.location.flowsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.location.flowsample.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels()
    private lateinit var mainBinding:ActivityMainBinding
    private var isRegist = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

//        viewModel.stateFlow.flowCollect {
//            mainBinding.stateFlowText.text = it
//        }
        App.instance.testStateFlow.flowCollect {
            Log.i("txlTest", "testStateFlow collect $it")
            mainBinding.stateFlowText.text = it.toString()
        }

        mainBinding.stateFlowBtn.setOnClickListener {
//            viewModel.dataChange()
           App.instance.add()
        }

        viewModel.stateFlow
            .flowCollect {
                mainBinding.stateFlowText.text = it
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

        mainBinding.jumpNewPageFlowBtn.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
        viewModel.toastFlow.flowCollect {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        }
        mainBinding.toastBtn.setOnClickListener {
            viewModel.toast();
        }
    }

    private fun <T> Flow<T>.flowCollect(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        block: suspend (value: T) -> Unit
    ) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(state) {
                collect(action = block)
            }
        }
    }
}