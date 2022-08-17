package com.location.composesample

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.location.composesample.bottom.HomeScreen
import com.location.composesample.bottom.WeightScreen
import com.location.composesample.weight.*

/**
 *
 * @author tianxiaolong
 * time：2022/8/3 11:07
 * description：
 */

fun NavGraphBuilder.weightGraph(navigateRotate: (String) -> Unit, back: () -> Unit) {
    navigation(
        route = HomeScreen.Weight.rotateName,
        startDestination = WeightScreen.Home.rotateName,
    ){
        composable(route = WeightScreen.Home.rotateName){
            ScreenWeightListWeight(
                items = listOf(
                    "Button",
                    "Text",
                    "TextFiled",
                    "Image",
                    "CheckBox",
                    "RadioButton",
                    "Slider",
                    "Snackbar"
                )
            ) { _, item ->
                when(item){
                    "Button" -> navigateRotate(WeightScreen.Button.rotateName)
                    "Text" -> navigateRotate(WeightScreen.Text.rotateName)
                    "TextFiled" -> navigateRotate(WeightScreen.TextFiled.rotateName)
                    "Image" -> navigateRotate(WeightScreen.Image.rotateName)
                    "CheckBox" -> navigateRotate(WeightScreen.CheckBox.rotateName)
                }
            }
        }
        composable(route = WeightScreen.Button.rotateName){
            WeightButton(back)
        }
        composable(route = WeightScreen.Text.rotateName){
            WeightText(back)
        }
        composable(route = WeightScreen.TextFiled.rotateName){
            WeightTextField(back)
        }
        composable(route = WeightScreen.Image.rotateName){
            WeightImage(back)
        }
        composable(route = WeightScreen.CheckBox.rotateName){
            WeightCheckbox(back)
        }
    }

}

@Composable
fun WeightGraph(nav: NavHostController, modifier: Modifier = Modifier, items: List<String>) {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreenWeightListWeight(
    modifier: Modifier = Modifier,
    items: List<String>,
    onClick: (index: Int, item: String) -> Unit
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        content = {
            itemsIndexed(items) { index, item ->
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    OutlinedButton(
                        onClick = {
//                            itemClick(index, item)
                            onClick(index, item)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        Text(text = item)
                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun ScreenTestWeightPreview() {
    ScreenWeightListWeight(
        items = listOf(
            "Button",
            "Text",
            "TextFiled",
            "CheckBox",
            "RadioButton",
            "Slider",
            "Snackbar"
        )
    ) { _, _ ->
    }
}
