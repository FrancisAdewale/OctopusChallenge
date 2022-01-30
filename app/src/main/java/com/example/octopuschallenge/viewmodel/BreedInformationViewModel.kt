package com.example.octopuschallenge.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.CatResponse
import com.example.model.Image
import com.example.octopuschallenge.API_KEY
import com.example.octopuschallenge.network.CatService
import kotlinx.coroutines.launch

class BreedInformationViewModel : ViewModel() {

    var breedData : List<CatResponse> by mutableStateOf(listOf())
    var breedImageData : List<Image> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var loadingState : Boolean by mutableStateOf(true)

    companion object{
        lateinit var breedName: String
        lateinit var breedId: String
    }

    fun getBreedInfo() {
        viewModelScope.launch {

            val breed = CatService.getInstance()
            try {
                breedData = breed.getBreedInfo(breedName, API_KEY)
                loadingState = false
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun getBreedImage() {
        viewModelScope.launch {
            val breed = CatService.getInstance()
            try {
                breedImageData = breed.getBreedImage(breedId, 100, API_KEY)
                loadingState = false
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}
