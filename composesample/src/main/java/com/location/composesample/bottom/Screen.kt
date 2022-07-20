package com.location.composesample.bottom

import androidx.annotation.StringRes
import com.location.composesample.R

/**
 *
 * @author tianxiaolong
 * time：2022/7/20 15:44
 * description：
 */
sealed class Screen(val rotateName:String, @StringRes val titleId:Int){
    object Weight : Screen("home/weight", R.string.screen_weight)
    object Layout : Screen("home/layout", R.string.screen_layout)
}
