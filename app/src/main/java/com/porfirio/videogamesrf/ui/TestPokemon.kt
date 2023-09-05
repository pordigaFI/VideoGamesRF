package com.porfirio.videogamesrf.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.porfirio.videogamesrf.data.remote.PokemonApi
import com.porfirio.videogamesrf.data.remote.model.PokemonDetailDto
import com.porfirio.videogamesrf.databinding.ActivityTestPokemonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestPokemon : AppCompatActivity() {

        private lateinit var binding: ActivityTestPokemonBinding

        private val BASE_URL = "https://pokeapi.co/"

        private val LOGTAG = "LOGS"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityTestPokemonBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val pokemonApi: PokemonApi = retrofit.create(PokemonApi::class.java)

            val call: Call<PokemonDetailDto> = pokemonApi.getPokemonDetail("550")

            call.enqueue(object: Callback<PokemonDetailDto> {
                override fun onResponse(
                    call: Call<PokemonDetailDto>,
                    response: Response<PokemonDetailDto>
                ) {
                    Log.d(LOGTAG, "${response.body()?.sprites?.other?.officialArtwork?.frontDefault}")

                    Glide.with(this@TestPokemon)
                        .load(response.body()?.sprites?.other?.officialArtwork?.frontDefault)
                        .into(binding.ivPokemon)
                }

                override fun onFailure(call: Call<PokemonDetailDto>, t: Throwable) {

                }

            })
        }
    }
