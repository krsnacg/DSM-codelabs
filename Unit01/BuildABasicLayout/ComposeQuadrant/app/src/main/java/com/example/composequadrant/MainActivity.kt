package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantApp(
                        firstTitle = stringResource(R.string.first_title),
                        first = stringResource(R.string.first_desc),
                        secondTitle = stringResource(R.string.second_title),
                        second = stringResource(R.string.second_desc),
                        thirdTitle = stringResource(R.string.third_title),
                        third = stringResource(R.string.third_desc),
                        fourthTitle = stringResource(R.string.fourth_title),
                        fourth = stringResource(R.string.fourth_desc)
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(
    firstTitle: String,
    first: String,
    secondTitle: String,
    second: String,
    thirdTitle: String,
    third: String,
    fourthTitle: String,
    fourth: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier.weight(1F)) {
            Quadrant(
                title = firstTitle,
                desc = first,
                background = Color(0xFFEADDFF),
                modifier = modifier.weight(weight = 1F, fill = false)
            )
            Quadrant(
                title = secondTitle,
                desc = second,
                background = Color(0xFFD0BCFF),
                modifier = modifier.weight(weight = 1F, fill = false)
            )
        }
        Row(modifier = modifier.weight(1F)) {
            Quadrant(
                title = thirdTitle,
                desc = third,
                background = Color(0xFFB69DF8),
                modifier = modifier.weight(weight = 1F, fill = false)
            )
            Quadrant(
                title = fourthTitle,
                desc = fourth,
                background = Color(0xFFF6EDFF),
                modifier = modifier.weight(weight = 1F, fill = false)
            )
        }
    }


}

@Composable
fun Quadrant(title: String, desc: String, background: Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier.background(background)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = modifier
                    .padding(bottom = 16.dp)
                //.weight(0.25F)
            )
            Text(text = desc, color = Color.Black, textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantApp(
            firstTitle = stringResource(R.string.first_title),
            first = stringResource(R.string.first_desc),
            secondTitle = stringResource(R.string.second_title),
            second = stringResource(R.string.second_desc),
            thirdTitle = stringResource(R.string.third_title),
            third = stringResource(R.string.third_desc),
            fourthTitle = stringResource(R.string.fourth_title),
            fourth = stringResource(R.string.fourth_desc)
        )
    }
}