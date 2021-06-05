package com.example.multigenpokedexapp.data.api.models.singlepokemonmodels

import com.google.gson.annotations.SerializedName


data class TypeDTO (
    @SerializedName("name")val name: String,
    @SerializedName("url")val url: String
)