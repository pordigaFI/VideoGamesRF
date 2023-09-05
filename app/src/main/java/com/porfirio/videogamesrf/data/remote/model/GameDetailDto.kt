package com.porfirio.videogamesrf.data.remote.model

import com.google.gson.annotations.SerializedName

data class GameDetailDto (
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("long_desc")  //Asi esta declarada mi variable
    var longDesc: String? = null    //Asi la manejo en mi programación
)