package com.location.flowsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.location.flowsample.databinding.ActivitySecondBinding
import kotlinx.coroutines.suspendCancellableCoroutine

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }

        binding.testBtn.setOnClickListener {
            Log.i("txlTest", "SecondActivity click")
            App.instance.add()
        }
    }




}