package com.location.composesample.bottom

import android.app.Activity
import android.content.Context
import androidx.annotation.StringRes
import com.location.composesample.R

/**
 *
 * @author tianxiaolong
 * time：2022/7/20 15:44
 * description：
 */
sealed class HomeScreen(val rotateName:String, @StringRes val titleId:Int){
    object Weight : HomeScreen("home/weight_graph", R.string.screen_weight)
    object Layout : HomeScreen("home/layout", R.string.screen_layout)
}


