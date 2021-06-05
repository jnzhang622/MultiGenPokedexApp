package com.example.multigenpokedexapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multigenpokedexapp.data.api.models.PokemonGenResponseDTO
import com.example.multigenpokedexapp.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.multigenpokedexapp.repos.PokemonRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val pokemonRepo: PokemonRepo by lazy{
        PokemonRepo()
    }

    private var _pokemonGenInfo = MutableLiveData<PokemonGenResponseDTO>()
    val pokemonGenInfo get() = _pokemonGenInfo

    private var _singlePokemonInfo = MutableLiveData<SinglePokemonResponseDTO>()
    val singlePokemonInfo get() = _singlePokemonInfo

    fun getPokemonGenData(offset: String, limit: String){
        viewModelScope.launch {
            try {
                val getGen1Poke = async{pokemonRepo.getGenPokemon(offset, limit)}
                pokemonGenInfo.value = getGen1Poke.await().body()
            }catch (e: Exception){
                onGetPokemonError(e)
            }
        }
    }

    var singlePokemonName = ""
    fun getSinglePokemonData(){
        viewModelScope.launch {
            try {
                val getSinglePoke = async{pokemonRepo.getSinglePokemon(singlePokemonName)}
                singlePokemonInfo.value = getSinglePoke.await().body()
            }catch (e: Exception){
                onGetPokemonError(e)
            }
        }
    }

    private fun onGetPokemonError(e: Throwable) {
        e.message.let { Log.d(TAG, it.toString()) }
    }

    companion object {
        private val TAG = MainViewModel::class.java.name
    }
}