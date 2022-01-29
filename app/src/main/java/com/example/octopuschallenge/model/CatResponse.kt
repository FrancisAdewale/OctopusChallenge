package com.example.model

import com.google.gson.annotations.SerializedName


data class CatResponse (

  @SerializedName("description"        ) var description      : String? = null,
  @SerializedName("image"              ) var image            : Image?  = Image(),
  @SerializedName("name"               ) var name             : String? = null,
  @SerializedName("origin"             ) var origin           : String? = null,


)