package com.example.multigenpokedexapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.multigenpokedexapp.data.adapters.singlePokemonAdapters.AbilityAdapter
import com.example.multigenpokedexapp.data.adapters.singlePokemonAdapters.MovesAdapter
import com.example.multigenpokedexapp.data.adapters.singlePokemonAdapters.TypesAdapter
import com.example.multigenpokedexapp.databinding.PokemonInfoFragmentBinding
import java.util.*

class PokemonInfoFragment : Fragment() {
    private var _binding: PokemonInfoFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View {

        _binding = PokemonInfoFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.singlePokemonInfo.observe(viewLifecycleOwner, {

            Glide.with(binding.spriteIv)
                .load(viewModel.singlePokemonInfo.value?.sprites?.front_default)
                .into(binding.spriteIv)

            binding.nameTv.text = viewModel.singlePokemonInfo.value?.name?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }

            binding.abilityRv.adapter = AbilityAdapter(viewModel.singlePokemonInfo.value?.abilities)
            binding.movesRv.adapter = MovesAdapter(viewModel.singlePokemonInfo.value?.moves)
            binding.typeRv.adapter = TypesAdapter(viewModel.singlePokemonInfo.value?.types)

        })

    }


}