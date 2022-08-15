package com.location.composesample.weight

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.location.composesample.TitleBar
import com.location.composesample.bottom.WeightScreen

/**
 *
 * @author tianxiaolong
 * time：2022/8/15 14:16
 * description：
 */
@Composable
fun WeightCheckbox(back: () -> Unit) {
    TitleBar(title = "CheckBox", back = back) {
        Column {
            var checked by remember {
                mutableStateOf(false)
            }
            Checkbox(checked = checked, onCheckedChange = {
                checked = it
            })

        }
    }
}

@Preview
@Composable
fun PreviewCheckBox() {
    WeightCheckbox {

    }
}