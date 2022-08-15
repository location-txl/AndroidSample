package com.location.composesample.weight

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.location.composesample.R
import com.location.composesample.TitleBar

/**
 *
 * @author tianxiaolong
 * time：2022/8/12 19:26
 * description：
 */
@Composable
fun WeightText(back: () -> Unit) {

    TitleBar(title = "文本", back = back) {
        Column {
            Text(text = "粗体文本", fontWeight = FontWeight.Bold)
            Text(text = "细点的", fontWeight = FontWeight.Medium)
            Text(text = "斜体文本", fontStyle = FontStyle.Italic)
            Text(text = "粗斜体文本", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
            Text(text = stringResource(id = R.string.weight_text))
            //超长文字...
            Text(
                text = "《狂人日记》是鲁迅创作的第一个短篇白话文日记体小说，也是中国第一部现代白话小说，写于1918年4月。该文首发于1918年5月15日4卷5号的《新青年》月刊，后收入《呐喊》集，编入《鲁迅全集》第一卷",
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text("居中对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text("右对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right)

            Text(text = "第一行 修改行间距 \n第二行", lineHeight = 30.sp)
        }
    }
}