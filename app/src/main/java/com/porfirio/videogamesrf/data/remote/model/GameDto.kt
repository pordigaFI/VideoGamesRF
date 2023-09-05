package com.porfirio.videogamesrf.data.remote.model

import com.google.gson.annotations.SerializedName

data class GameDto (
    //Dto = Data transfer object
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("thumbnail")
    var thumbnail: String? = null,
    @SerializedName("title")
    var title: String? = null
)
