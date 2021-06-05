package com.example.multigenpokedexapp.repos

import com.example.multigenpokedexapp.data.api.models.PokemonGenResponseDTO
import com.example.multigenpokedexapp.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.multigenpokedexapp.data.api.network.PokemonAPIManager
import retrofit2.Response

class PokemonRepo {

    suspend fun getGenPokemon(offset: String, limit: String) : Response<PokemonGenResponseDTO> {
        return PokemonAPIManager().getGenPokemon(
            offset, limit
        )
    }

    suspend fun getSinglePokemon(name: String) : Response<SinglePokemonResponseDTO> {
        return PokemonAPIManager().getSinglePokemon(
            name
        )
    }

}