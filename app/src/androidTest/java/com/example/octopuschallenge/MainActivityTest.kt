package com.example.octopuschallenge

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.model.CatResponse
import com.example.octopuschallenge.ui.theme.OctopusChallengeTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    val composeTestRule = createAndroidComposeRule<MainActivity>()
        @Rule get

    @Test
    fun testBreedListScreenIfBreedsListIsEmpty() {

        composeTestRule.setContent {
            OctopusChallengeTheme {
                GetBreedist(emptyList())
            }
        }

        composeTestRule.onNodeWithTag(BREED_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(0)

    }

    @Test
    fun testBreedListScreenIfBreedsListIsNotEmpty() {
        val breeds = listOf(
            CatResponse("breed info", null, "breed1", "Breedville", "1"),
            CatResponse("breed info", null, "breed2", "Breedville", "2"),
            CatResponse("breed info", null, "breed3", "Breedville", "3"),
            CatResponse("breed info", null, "breed4", "Breedville", "4"),
            CatResponse("breed info", null, "breed5", "Breedville", "5")
        )

        composeTestRule.setContent {
            OctopusChallengeTheme {
                GetBreedist(breeds)
            }
        }

        composeTestRule.onNodeWithTag(BREED_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(5)
    }


    @Test
    fun testFirstAndLastBreedListName() {

        composeTestRule.setContent {
            OctopusChallengeTheme {
                GetBreedist(getDummyBreedsList())
            }
        }

        composeTestRule.apply {

            onNodeWithTag(BREED_LIST_TEST_TAG)
                .onChildren()
                .onFirst()
                .assert(hasText("breed1"))

            onNodeWithTag(BREED_LIST_TEST_TAG)
                .onChildren()
                .onLast()
                .assert(hasText("breed5"))
        }

    }

    private fun getDummyBreedsList(): List<CatResponse> {

        return listOf(
            CatResponse("breed info", null, "breed1", "Breedville", "1"),
            CatResponse("breed info", null, "breed2", "Breedville", "2"),
            CatResponse("breed info", null, "breed3", "Breedville", "3"),
            CatResponse("breed info", null, "breed4", "Breedville", "4"),
            CatResponse("breed info", null, "breed5", "Breedville", "5")
        )

    }


}