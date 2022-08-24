package com.udacity.shoestore.shoes_list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoes_list.*
import kotlinx.android.synthetic.main.shoes_item.view.*

class ShoesListFragment : Fragment() {
    private lateinit var binding: FragmentShoesListBinding
    private val shoesViewModel: ShoesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShoesListBinding.inflate(inflater, container, false)
        binding.shoeListFragment = this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        shoesViewModel.liveShoesList.observe(viewLifecycleOwner) {
            binding.shoesLinearLayout.removeAllViews()
            it.map {shoe->
                setUpList(shoe)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun setUpList(shoe: Shoe) {
        val view = layoutInflater.inflate(R.layout.shoes_item, null)
        view.name.text = shoe.name
        view.company.text = shoe.company
        view.size.text = shoe.size.toString()
        view.desc.text = shoe.description
        binding.shoesLinearLayout.addView(view.rootView)
    }


    fun navigateToAddShoes() {
        findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToAddShoesFragment())
    }
}