package com.porfirio.videogamesrf.data

import com.porfirio.videogamesrf.data.remote.GamesApi
import com.porfirio.videogamesrf.data.remote.model.GameDetailDto
import com.porfirio.videogamesrf.data.remote.model.GameDto
import retrofit2.Call
import retrofit2.Retrofit

class GameRepository(private val retrofit: Retrofit) {
    private val gamesApi: GamesApi = retrofit.create(GamesApi :: class.java)

    fun getGames(url: String): Call<List<GameDto>> =
        gamesApi.getGames(url)

    fun getGameDetail(id: String?): Call<GameDetailDto> =
        gamesApi.getGameDetail(id)

    fun getGamesApiary(): Call<List<GameDto>> =
        gamesApi.getGamesApiary()

    fun getGameDetailApiary(id: String?): Call<GameDetailDto> =
        gamesApi.getGameDetailApiary(id)
}