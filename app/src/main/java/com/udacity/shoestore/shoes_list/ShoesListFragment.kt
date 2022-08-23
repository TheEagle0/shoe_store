package com.udacity.shoestore.shoes_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoes_list.*

class ShoesListFragment : Fragment() {
    private lateinit var binding: FragmentShoesListBinding
    private val shoesViewModel by lazy { ViewModelProvider(this)[ShoesViewModel::class.java] }
    private val shoe: Shoe? by lazy { requireArguments().getParcelable("shoe") }
    private val adapter by lazy { ShoesAdapter(mutableListOf()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShoesListBinding.inflate(inflater, container, false)
        binding.shoeListFragment=this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setUpList()
        shoe?.let {
            shoesViewModel.addShoes(it)
        }
        shoesViewModel.liveShoesList.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
    private fun setUpList() {
        binding.shoesRV.layoutManager = LinearLayoutManager(requireContext())
        shoesRV.adapter = adapter
    }

     fun navigateToAddShoes() {
        findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToAddShoesFragment())
    }
}