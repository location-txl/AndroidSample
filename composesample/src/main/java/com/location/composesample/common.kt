package com.location.composesample

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavHostController

/**
 *
 * @author tianxiaolong
 * time：2022/7/20 15:56
 * description：
 */

private val listStr = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", )
@Composable
fun ScreenWeight(nav: NavHostController){

    var value by remember {
        mutableStateOf("默认")
    }
    Log.d("txlTest", "ScreenWeight")
    var count:Int by remember {
        mutableStateOf(0)
    }
    Column {
        Text(text = "weight")
        Text(text = value)
//        Button(onClick = {
//           count += 1
//            Log.d("txlTest", "ScreenWeight click count:$count")
//            value = "count:${count}"
//        }) {
//            Text(text = "点击")
//        }

        LazyColumn {

            items(listStr) {
                Button(onClick = {
//                    count += 1
//                    Log.d("txlTest", "ScreenWeight click count:$count")
//                    value = "count:${count}"
                }) {
                    Text(text = it)
                }
            }
        }

    }


}

@Composable
fun ScreenLayout(nav: NavHostController){

//    Text(text = "ScreenLayout")
    var value by remember {
        mutableStateOf("默认")
    }
    Log.d("txlTest", "ScreenWeight")
    var count:Int by remember {
        mutableStateOf(0)
    }
    Column {
        Text(text = "layout")
        Text(text = value)
        Button(onClick = {
            count += 1
            Log.d("txlTest", "ScreenWeight click count:$count")
            value = "count:${count}"
        }) {
            Text(text = "点击")
        }
    }
}