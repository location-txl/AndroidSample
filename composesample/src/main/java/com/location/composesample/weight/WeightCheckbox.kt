package com.location.composesample.weight

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.location.composesample.CheckBoxText
import com.location.composesample.IconCheckBox
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
            CheckBoxText("复选框1", initChecked = true){

            }

            CheckBoxText("复选框2", initChecked = false){

            }

            Text(text = "自定义复选框", style = MaterialTheme.typography.h6)
            var checked by remember {
                mutableStateOf(false)
            }
            IconCheckBox(checked, "复选框3", space = 2.dp) {
                checked = it
            }
        }
    }
}

@Preview
@Composable
fun PreviewCheckBox() {
    WeightCheckbox {

    }
}