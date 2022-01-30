package com.example.octopuschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.octopuschallenge.ui.theme.OctopusChallengeTheme

class BreedInformation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OctopusChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val context = LocalContext.current
                    val intent = (context as BreedInformation).intent
                    val breed = intent.getStringExtra(BREED_NAME_KEY)
                    ConstraintLayoutContent(breed!!)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OctopusChallengeTheme {
        val breedName = "Bengal"
        ConstraintLayoutContent(breedName)
    }
}

@Composable
fun ConstraintLayoutContent(breedName: String?) {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
    ){
        val (breedTitle, breedDesc, breedOrigin) = createRefs()

        Text(
            text = breedName!!, Modifier
            .constrainAs(breedTitle){
            top.linkTo(parent.top, 10.dp)
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 10.dp)
        },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text()

    }

}