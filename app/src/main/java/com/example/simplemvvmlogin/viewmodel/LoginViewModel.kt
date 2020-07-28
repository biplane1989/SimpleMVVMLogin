package com.example.simplemvvmlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var title: MutableLiveData<String> = MutableLiveData()
    var accout: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()
    var ok: MutableLiveData<String> = MutableLiveData()
    var _ok = MutableLiveData<String>()

    init {
        title.value = "L O G I N"
        accout.value = "Accout"
        password.value = "Password"
        ok.value = "OK"
    }

    fun onOKClick() {
        _ok.value = ""
    }

    fun onCheck(accout: String, password: String): Boolean {
     //   if (accout == "1" && password == "1")
            return true
        return false
    }
}