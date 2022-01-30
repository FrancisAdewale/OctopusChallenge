package com.example.octopuschallenge

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.model.CatResponse
import com.example.model.Image
import com.example.octopuschallenge.ui.theme.OctopusChallengeTheme
import com.example.octopuschallenge.viewmodel.BreedInformationViewModel

class BreedInformation : ComponentActivity() {

    private val breedInformationViewModel: BreedInformationViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OctopusChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val breed = getBreedName()
                    BreedInformationViewModel.breedName = breed!!.replace(" ", "_")
                    breedInformationViewModel.getBreedInfo()
                    Log.d("breedData", breedInformationViewModel.breedData.toString())
                    if(breedInformationViewModel.breedData.isNotEmpty()) {
                        ConstraintLayoutContent(breedInfo = breedInformationViewModel.breedData)
                    }
                }
            }
        }
    }

    @Composable
    private fun getBreedName(): String? {
        val context = LocalContext.current
        val intent = (context as BreedInformation).intent
        return intent.getStringExtra(BREED_NAME_KEY)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OctopusChallengeTheme {
        val image = Image(
            50,
            "Meh",
            "https://howtodoandroid.com/images/coco.jpg",
            50

        )
        val breed = CatResponse(
            "A loyal cat, that's for certain",
            image,
            "Bengal",
            "Asia"
        )
        //ConstraintLayoutContent(breed)
    }
}

@Composable
fun ConstraintLayoutContent(breedInfo: List<CatResponse>) {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
    ){
        val (breedTitle, breedDesc, breedOrigin) = createRefs()

        Text(
            text = breedInfo[0].name!!, Modifier
            .constrainAs(breedTitle){
            top.linkTo(parent.top, 10.dp)
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 10.dp)
        },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = breedInfo[0].origin!!, Modifier
                .constrainAs(breedOrigin) {
                    top.linkTo(breedTitle.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                },
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            text = breedInfo[0].description!!, Modifier
                .constrainAs(breedDesc) {
                    top.linkTo(breedOrigin.bottom, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                    absoluteRight.linkTo(parent.absoluteRight)
                },
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )

    }

}
