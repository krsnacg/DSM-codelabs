package com.example.artspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpace(
                    name = "Android",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
fun ArtSpace(modifier: Modifier = Modifier, name:String = "Android") {

    var result by remember { mutableIntStateOf(0) }

    val artResources = listOf(
        Triple(R.drawable.space, R.string.space_artwork_title, R.string.space_artwork_author),
        Triple(R.drawable.aurora, R.string.aurora_artwork_title, R.string.aurora_artwork_author),
        Triple(R.drawable.flower, R.string.flower_artwork_title, R.string.flower_artwork_author),
        Triple(R.drawable.person, R.string.person_artwork_title, R.string.person_artwork_author),
        Triple(R.drawable.chair, R.string.chair_artwork_title, R.string.chair_artwork_author),
        Triple(R.drawable.beach_house, R.string.beach_house_artwork_title, R.string.beach_house_artwork_author)
    )

    Log.d("ArtSpace", "Current result: $result")

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtSection(modifier = Modifier.weight(1F), artResources[result].first)

        ArtDescription(title = artResources[result].second, author = artResources[result].third)
        Controllers(
            result = result,
            onPreviousClick = {
                result = if (result > 1) result - 1 else artResources.lastIndex
                Log.d("ArtSpace", "Previous clicked. New result: $result")
            },
            onNextClick = {
                result = if (result < artResources.lastIndex) result + 1 else 0
                Log.d("ArtSpace", "Next clicked. New result: $result")
            }
        )
    }

}

@Composable
fun ArtSection(modifier: Modifier = Modifier, @DrawableRes image: Int) {
    Box(modifier = modifier.padding(top = 48.dp), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier.sizeIn(maxWidth = 340.dp, maxHeight = 440.dp),
            shadowElevation = 16.dp
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Composable
fun ArtDescription(modifier: Modifier = Modifier, @StringRes title: Int, @StringRes author: Int) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(8.dp)
        )
        Text(
            text = stringResource(author),
            fontStyle = FontStyle.Italic,
            modifier = modifier.padding(8.dp)
        )
    }
}

@Composable
fun Controllers(
    modifier: Modifier = Modifier,
    result: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onPreviousClick) {
            Text(text = stringResource(R.string.button_desc_previous))
        }
        Spacer(modifier = Modifier.width(96.dp))
        Button(onClick = onNextClick) {
            Text(text = stringResource(R.string.button_desc_next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtAppPreview() {
    ArtSpaceTheme {
        ArtSpace(name = "Android", modifier = Modifier.fillMaxSize())
    }
}