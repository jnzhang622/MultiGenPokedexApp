package com.example.multigenpokedexapp.data.api.models

import com.google.gson.annotations.SerializedName

data class PokemonGenResponseDTO (
    @SerializedName("results")val results: List<PokemonResultsDTO>
)