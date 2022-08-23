package com.udacity.shoestore.shoes_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
     val _liveShoesList = MutableLiveData<MutableList<Shoe>>()
    val liveShoesList: LiveData<MutableList<Shoe>>
        get() = _liveShoesList

    fun addShoes(shoe: Shoe) {
        if (_liveShoesList.value != null) {
            val oldList = _liveShoesList.value
            val newList = oldList.apply {
                this?.add(shoe)
            }
            _liveShoesList.postValue(newList!!)
        }else{
            _liveShoesList.postValue(mutableListOf(shoe))
        }
    }
}
