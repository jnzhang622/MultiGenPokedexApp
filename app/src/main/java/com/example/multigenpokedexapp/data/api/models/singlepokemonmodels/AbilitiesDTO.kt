package com.example.multigenpokedexapp.data.api.models.singlepokemonmodels

import com.google.gson.annotations.SerializedName

data class AbilitiesDTO (
    @SerializedName("ability")val ability: AbilityDTO
)