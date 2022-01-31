package com.example.octopuschallenge

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
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
class ExampleInstrumentedTest {

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


}