package com.udacity.shoestore.add_shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoesBinding
import com.udacity.shoestore.models.Shoe

class AddShoesFragment : Fragment() {
private lateinit var binding: FragmentAddShoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentAddShoesBinding.inflate(inflater,container,false)
        binding.addShoesFragment=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
    fun popBack(){
        findNavController().popBackStack()

    }
fun navigateToShoesList(){
    val shoeName=binding.nameET.text.toString()
    val shoeSize=binding.sizeET.text.toString()
    val shoeDescription=binding.descET.text.toString()
    val shoeCompany=binding.companyET.text.toString()
    if (shoeName.isEmpty()||shoeSize.isEmpty()||shoeDescription.isEmpty()||shoeCompany.isEmpty())
        Toast.makeText(requireContext(),"Please fill all above field",Toast.LENGTH_SHORT).show()
    else findNavController().navigate(AddShoesFragmentDirections.actionAddShoesFragmentToShoesListFragment(
        Shoe(shoeName,shoeSize.toDouble(),shoeCompany,shoeDescription)
    ))
}
}