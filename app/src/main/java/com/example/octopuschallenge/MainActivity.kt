package com.example.octopuschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.octopuschallenge.ui.theme.OctopusChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OctopusChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Title()

                }
            }
        }
    }
}

@Composable
fun Title() {
    Text(
        text = "Choose Breed",
        style = MaterialTheme.typography.h1,
        fontSize = 30.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Breeds() {
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        Text(text = )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OctopusChallengeTheme {
        Title()
    }
}