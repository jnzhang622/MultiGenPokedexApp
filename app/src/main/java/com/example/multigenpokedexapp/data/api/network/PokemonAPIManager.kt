package com.example.multigenpokedexapp.data.api.network

import com.example.multigenpokedexapp.data.api.models.PokemonGenResponseDTO
import com.example.multigenpokedexapp.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class PokemonAPIManager {
    private val service: PokemonApiService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(PokemonApiService::class.java)
    }

    suspend fun getSinglePokemon(name: String): Response<SinglePokemonResponseDTO> {
        return service.getSinglePokemon(name)
    }

    suspend fun getGenPokemon(offset: String, limit: String): Response<PokemonGenResponseDTO> {
        return service.getGenPokemon(offset, limit)
    }

    interface PokemonApiService {

        @GET("/api/v2/pokemon/{name}")
        suspend fun getSinglePokemon(
            @Path("name") name: String,
        ): Response<SinglePokemonResponseDTO>

        @GET("/api/v2/pokemon/")
        suspend fun getGenPokemon(
            @Query("offset") offset: String,
            @Query("limit") limit: String,
        ): Response<PokemonGenResponseDTO>

    }
}
