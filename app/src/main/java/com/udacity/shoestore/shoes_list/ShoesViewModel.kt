package com.udacity.shoestore.shoes_list

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    val _liveShoesList = MutableLiveData<MutableList<Shoe>>()
    val liveShoesList: LiveData<MutableList<Shoe>>
        get() = _liveShoesList

    var name = ObservableField("")
    var size = ObservableField("")
    var desc = ObservableField("")
    var company = ObservableField("")

    fun addShoes(): Boolean {
        if (!checkValidity()) return false
        val shoe = Shoe(name.get()!!, size.get()!!.toDouble(), company.get()!!, desc.get()!!)
        if (_liveShoesList.value != null) {
            val oldList = _liveShoesList.value
            val newList = oldList.apply {
                this?.add(shoe)
            }
            _liveShoesList.postValue(newList!!)
        } else {
            _liveShoesList.postValue(mutableListOf(shoe))
        }
        //
        name.set("")
        company.set("")
        desc.set("")
        size.set("")
        return true
    }

    private fun checkValidity(): Boolean {
        val shoeName = name.get() ?: ""
        val shoeSize = size.get() ?: ""
        val shoeDescription = desc.get() ?: ""
        val shoeCompany = company.get() ?: ""
        return if (shoeName.isEmpty() || shoeSize.isEmpty() || shoeDescription.isEmpty() || shoeCompany.isEmpty()) {
            return false
        } else
            true
    }
}
