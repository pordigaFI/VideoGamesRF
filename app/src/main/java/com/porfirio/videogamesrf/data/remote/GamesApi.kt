package com.porfirio.videogamesrf.data.remote

import com.porfirio.videogamesrf.data.remote.model.GameDetailDto
import com.porfirio.videogamesrf.data.remote.model.GameDto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GamesApi {
    @GET
    fun getGames(
        @Url url:String?
    ): Call<List<GameDto>>
    //getGames("cm/games/games_list.php")
    @GET("cm/games/game_detail.php")
    fun getGameDetail(
        @Query("id") id: String?/*,
        @Query("name") name: String?

        Esta notación se usa cuando tenemos mas parametros*/

    ): Call<GameDetailDto>

    //getGamesDetail("21347")
    //cm/games/game_detail.php?id=21347&name=Porfirio


    //Para Apiary
    @GET("games/games_list")
    fun getGamesApiary(): Call<List<GameDto>>

    //games/game_detail/21357
    @GET("games_detail/{id}")
    fun getGameDetailApiary(
        @Path("id") id: String?/*,
        @Path("name") name:String?

        Notacion para mas parametros*/

    ): Call <GameDetailDto>




}