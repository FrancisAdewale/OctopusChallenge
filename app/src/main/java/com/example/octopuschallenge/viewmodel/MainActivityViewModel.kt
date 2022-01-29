package com.example.octopuschallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.CatResponse
import com.example.octopuschallenge.API_KEY
import com.example.octopuschallenge.network.CatService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var catData : List<CatResponse> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var loadingState : Boolean by mutableStateOf(true)

    fun getAllBreeds() {
        viewModelScope.launch {
            val breedList = CatService.getInstance()

            try {
                catData = breedList.getAllBreeds(API_KEY)
                loadingState = false
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}