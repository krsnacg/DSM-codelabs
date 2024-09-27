package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface (color = MaterialTheme.colorScheme.background) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    HeaderBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(color = Color(225, 220, 57, 255))
    )
    LemonCore(modifier = modifier.fillMaxSize())
}

@Composable
fun HeaderBar(modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(
            text = "Lemonade",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun LemonCore(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var secondStageRandomResult by remember { mutableIntStateOf(0) }
    val resourceImageText = when(result) {
        1 -> Pair(R.drawable.lemon_tree, R.string.tap_lemon_tree)
        2 -> Pair(R.drawable.lemon_squeeze,R.string.squeeze_lemon)
        3 -> Pair(R.drawable.lemon_drink, R.string.drink_lemonade)
        4 -> Pair(R.drawable.lemon_restart, R.string.tap_empty_glass)
        else -> Pair(R.drawable.lemon_tree, R.string.tap_lemon_tree)
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (result == 2 && secondStageRandomResult > 0) {
                    secondStageRandomResult--
                    if (secondStageRandomResult == 0) result ++
                } else {
                    if (result < 4) {
                        result++
                        if (result == 2) secondStageRandomResult = (2..4).random()
                    } else result = 1
                }
            },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color(171, 222, 201, 255),
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.LightGray
            ),
            border = BorderStroke(2.dp, Color(105, 205, 216))
        ) {
            Image(
                painter = painterResource(resourceImageText.first),
                contentDescription = result.toString(),
                contentScale = ContentScale.FillWidth,
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = stringResource(resourceImageText.second), fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            LemonadeApp()
        }
    }
}