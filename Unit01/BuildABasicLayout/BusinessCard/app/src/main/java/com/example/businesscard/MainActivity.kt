package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
        .padding(32.dp)) {
        CardTop(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth()
        )
        CardBottom(
            phone = stringResource(R.string.phone),
            social = stringResource(R.string.socialmediahandle),
            mail = stringResource(R.string.mail)
            //modifier = Modifier.weight(1F)
        )
    }
}
@Composable
fun CardTop(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .background(Color.DarkGray)
                .width(120.dp)
                .padding(4.dp)
        )
        Text(text = name, fontSize = 48.sp, modifier = Modifier.padding(8.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF229254),
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun CardBottom(phone: String, social: String, mail: String, modifier: Modifier = Modifier) {
    val phoneIcon = painterResource(R.drawable.call_24dp_e8eaed_fill0_wght400_grad0_opsz24)
    val mailIcon = painterResource(R.drawable.mail_24dp_e8eaed_fill0_wght400_grad0_opsz24)
    val shareIcon = painterResource(R.drawable.share_24dp_e8eaed_fill0_wght400_grad0_opsz24)
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = modifier.padding(start = 32.dp)) {
            Icon(
                painter = phoneIcon,
                contentDescription = stringResource(R.string.phone_icon_desc),
                tint = Color(0xFF229254),
                modifier = modifier.padding(8.dp)
            )
            Icon(
                painter = shareIcon,
                contentDescription = stringResource(R.string.share_icon_desc),
                tint = Color(0xFF229254),
                modifier = modifier.padding(8.dp)
            )
            Icon(
                painter = mailIcon,
                contentDescription = stringResource(R.string.mail_icon_desc),
                tint = Color(0xFF229254),
                modifier = modifier.padding(8.dp)
            )
        }
        Column(modifier = modifier.padding(start = 8.dp)) {
            Text(text = phone, modifier = modifier.padding(8.dp))
            Text(text = social, modifier = modifier.padding(8.dp))
            Text(text = mail, modifier = modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}