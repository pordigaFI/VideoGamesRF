package com.porfirio.videogamesrf.application

import android.app.Application
import com.porfirio.videogamesrf.data.GameRepository
import com.porfirio.videogamesrf.data.remote.model.RetrofitHelper

class VideoGamesRFApp: Application() {

    private val retrofit by lazy{
        RetrofitHelper().getRetrofit()
    }

    val repository by lazy{
        GameRepository(retrofit)
    }
}