package com.example.octopuschallenge

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.model.CatResponse
import com.example.model.Image
import com.example.octopuschallenge.ui.theme.OctopusChallengeTheme
import com.example.octopuschallenge.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {

    val mainViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OctopusChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GetBreedist(breedList = mainViewModel.catData)
                    mainViewModel.getAllBreeds()

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BreedItem() {
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

        BreedItem(breed, 0, 0, {

        } )
    }


}

@Composable
fun BreedItem(breed: CatResponse,
              index: Int,
              selecetedIndex: Int,
              onClick :(Int) -> Unit) {

    val context = LocalContext.current
    val intent = Intent(context, BreedInformation::class.java)

    val backgroundColour =
        if(index == selecetedIndex) MaterialTheme.colors.primary
        else MaterialTheme.colors.background

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable {
                onClick(index)
                intent.putExtra(BREED_NAME_KEY, breed.name!!)
                intent.putExtra(ID_KEY, breed.id!!)
                context.startActivity(intent)
            }
            .height(110.dp),
        shape =  RoundedCornerShape(8.dp),
        elevation = 4.dp
    ){
        Surface(color = backgroundColour) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(painter = rememberImagePainter(data = breed.image?.url,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.ic_launcher_foreground)
                        transformations(CircleCropTransformation())
                    }
                ),
                    contentDescription = "Breed", modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = breed.name!!,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = breed.origin!!,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )

                }
            }
        }
    }

}

@Composable
fun GetBreedist(breedList: List<CatResponse>){

    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn{
        itemsIndexed(items = breedList) { index, item ->
            BreedItem(breed = item, index, selectedIndex ) {
                selectedIndex = it
            }
        }
    }
}