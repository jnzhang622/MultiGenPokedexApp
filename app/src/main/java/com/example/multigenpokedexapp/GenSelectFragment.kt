package com.example.multigenpokedexapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.multigenpokedexapp.data.adapters.MainAdapter
import com.example.multigenpokedexapp.data.api.models.PokemonResultsDTO
import com.example.multigenpokedexapp.databinding.GenSelectFragmentBinding
import com.example.multigenpokedexapp.databinding.MainFragmentBinding

class GenSelectFragment : Fragment() {
    private var _binding: GenSelectFragmentBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = GenSelectFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.genIButton.setOnClickListener{
            viewModel.getPokemonGenData("0","151")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genIiButton.setOnClickListener{
            viewModel.getPokemonGenData("151", "100")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genIiiButton.setOnClickListener{
            viewModel.getPokemonGenData("251", "135")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genIvButton.setOnClickListener{
            viewModel.getPokemonGenData("386", "107")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genVButton.setOnClickListener{
            viewModel.getPokemonGenData("493", "156")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genViButton.setOnClickListener{
            viewModel.getPokemonGenData("649", "72")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genViiButton.setOnClickListener{
            viewModel.getPokemonGenData("721", "88")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}

        binding.genViiiButton.setOnClickListener{
            viewModel.getPokemonGenData("809", "89")
            findNavController().navigate(R.id.action_genSelectFragment_to_mainFragment)}
    }
}