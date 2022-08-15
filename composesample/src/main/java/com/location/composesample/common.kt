package com.location.composesample

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

/**
 *
 * @author tianxiaolong
 * time：2022/7/20 15:56
 * description：
 */



@Composable
fun SearchEdittext() {
    var text by remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF101324))
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF3F51B5), RoundedCornerShape(20.dp))
                .padding(top = 10.dp, bottom = 10.dp)
                .weight(1.0f)
        ) {
            BasicTextField(value = text,
                onValueChange = {
                    text = it
                },
                decorationBox = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        Icon(painterResource(R.drawable.search_icon), null)
                        Box(Modifier.weight(1f)) {
                            it()
                        }
                        if (text.isNotEmpty()) {
                            Image(
                                painterResource(R.drawable.delete_icon),
                                null,
                                modifier = Modifier
                                    .clickable {
                                        text = ""
                                    })
                        }
                    }
                }
            )
        }
        Text(
            text = "取消",
            modifier = Modifier
                .padding(start = 10.dp)
                .clickable {
                    text = ""
                },
            color = Color.White
        )
    }
}


inline fun LazyListScope.itemTitle(
    title: String,
    crossinline block: @Composable LazyItemScope.() -> Unit
) {
    item {
        Text(
            text = title,
            style = TextStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
        block()
    }
}


@Composable
fun LayoutGraph(nav: NavHostController, modifier: Modifier = Modifier) {
    ScreenLayout(modifier)
}

@Composable
fun ScreenLayout(modifier: Modifier = Modifier) {

//    Text(text = "ScreenLayout")
    //页面切换后保存状态
    var value by rememberSaveable {
        mutableStateOf("默认")
    }
    Log.d("txlTest", "ScreenWeight")
    var count: Int by rememberSaveable {
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


@Composable
fun TitleBar(title: String, back: () -> Unit, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            back()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ){
        Box(Modifier.padding(it)) {
            content()
        }
    }
}


@Composable
fun CheckBoxText(
    text: String,
    initChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
) {
    var value by remember(initChecked) {
        mutableStateOf(initChecked)
    }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = value,
//            onCheckedChange = {
//                value = it
//                onCheckedChange(it)
//            }
//        )
        RadioButton(selected = value,
            modifier = Modifier.background(Color.Red),
            onClick = {
            value = !value
        })
        Text(text = text)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCheckBoxText() {
    CheckBoxText("checkbox", false) {
        Log.d("txlTest", "checkbox:$it")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTitleBar() {
    TitleBar("标题", {}, {
        Column {
            Text(text = "内容")
        }
    })


}




@Preview(showBackground = true)
@Composable
fun searchEdittextPreview() {
    SearchEdittext()
}


@Preview(showBackground = true)
@Composable
fun testEdittext() {
    LazyColumn {
        items(35) {
            Text(
                text = "占位符$it",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "TextField")
                }
            )
        }

        item {
            var text by remember {
                mutableStateOf("")
            }
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .background(Color.Red),
            )
        }
    }
}



data class ButtonState(val text: String, val textColor: Color, val backgroundColor: Color)


