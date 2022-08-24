package com.udacity.shoestore.add_shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoes_list.ShoesViewModel

class AddShoesFragment : Fragment() {
    private lateinit var binding: FragmentAddShoesBinding
    private val shoesViewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddShoesBinding.inflate(inflater, container, false)
        binding.addShoesFragment = this
        binding.viewModel = shoesViewModel
        return binding.root
    }

    fun popBack() {
        findNavController().popBackStack()
    }

}