package com.example.simplemvvmlogin.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.simplemvvmlogin.R
import com.example.simplemvvmlogin.databinding.FragmentMainBinding
import com.example.simplemvvmlogin.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var loginBiding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginBiding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        loginBiding.lifecycleOwner = this
        loginBiding.loginViewModel = loginViewModel


        return loginBiding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel._ok.observe(loginBiding.lifecycleOwner!!, Observer {
            if (loginViewModel.onCheck(
                    edt_accout.text.toString(),
                    edt_password.text.toString()
                )
            ) {
                val directions = MainFragmentDirections.actionManagerToHome()
                NavHostFragment.findNavController(this).navigate(directions)
            } else Log.d("001", "erro")

        })

    }
}