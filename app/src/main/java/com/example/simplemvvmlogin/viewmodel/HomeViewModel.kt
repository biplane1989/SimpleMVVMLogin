package com.example.simplemvvmlogin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData()

    var add: MutableLiveData<String> = MutableLiveData()
    var _add = MutableLiveData<String>()

    val itemModel: MutableLiveData<MutableList<ItemViewModel>> by lazy {
        MutableLiveData<MutableList<ItemViewModel>>()
    }

    init {
        name.value = "Name"
        add.value = "Add"
    }

    fun initData(): MutableList<ItemViewModel> {
        var list = mutableListOf<ItemViewModel>()
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        list.add(ItemViewModel("orange"))
        return list
    }

    fun onClicked() {
        _add.value = ""
    }

    fun onItemClick() {
        Log.d("001", "clicked")
    }

}