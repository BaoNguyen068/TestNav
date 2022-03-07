package com.example.testnav

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel: ViewModel() {
    val selectItem = MutableLiveData<String>()
    val selectedItem : LiveData<String> get() = selectItem
    fun setData(item : String){
        selectItem.value=item
    }

}