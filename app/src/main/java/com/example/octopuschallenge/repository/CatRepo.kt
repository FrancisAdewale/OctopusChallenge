package com.example.octopuschallenge.repository

import com.example.octopuschallenge.network.CatService

class CatRepo(private val catService: CatService) {

    fun getAllBreeds() = catService.getAllBreeds()
}