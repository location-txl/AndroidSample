package com.location.androidsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.location.androidsample.ui.theme.AndroidSampleTheme
import com.location.androidsample.viewmodel.JavaViewModel
import com.location.androidsample.viewmodel.WanAndroidHomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * 如果您使用 @AndroidEntryPoint 为某个 Android 类添加注解，
 * 则还必须为依赖于该类的 Android 类添加注解。
 * 例如，如果您为某个 fragment 添加注解，
 * 则还必须为使用该 fragment 的所有 activity 添加注解。
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel: WanAndroidHomeViewModel by viewModels()
    private val viewmodel2: JavaViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        Log.i("MainActivity", "MainActivity: onCreate $viewmodel2")
        setContent {
            AndroidSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = viewmodel.countManager.name,
                        viewmodel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        lifecycleScope.launch(Dispatchers.IO){
            viewmodel.wanAndroidService.getArticleList(1)
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: WanAndroidHomeViewModel,   modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hello $name!")
        val countState = viewModel.countManager.countState.collectAsState()
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        Text(text = "Count: ${countState.value}")
        Button(onClick = {
            scope.launch{
                viewModel.countManager.start()
            }
        }) {
            Text(text = "start")
        }

        Button(onClick = {
            viewModel.countManager.stop()
        }) {
            Text(text = "stop")
        }
        Button(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text(text = "Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSampleTheme {
//        Greeting("Android", Hom)
    }
}