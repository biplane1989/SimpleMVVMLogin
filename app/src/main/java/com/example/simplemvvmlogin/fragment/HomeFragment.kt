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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemvvmlogin.R
import com.example.simplemvvmlogin.adapter.EmployeeAdapter
import com.example.simplemvvmlogin.commol.OnClickItem
import com.example.simplemvvmlogin.databinding.FragmentHomeBinding
import com.example.simplemvvmlogin.viewmodel.HomeViewModel
import com.example.simplemvvmlogin.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), OnClickItem {

    lateinit var homeViewModel: HomeViewModel
    lateinit var homeBiding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel.itemModel.value = homeViewModel.initData()

        homeBiding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        homeBiding.lifecycleOwner = this
        homeBiding.homeViewmodel = homeViewModel

        return homeBiding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var employeeAdapter: EmployeeAdapter = EmployeeAdapter(homeViewModel, viewLifecycleOwner)
        rv_employee.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        rv_employee.setHasFixedSize(true)
        rv_employee.adapter = employeeAdapter

        homeViewModel._add.observe(homeBiding.lifecycleOwner!!, Observer {
            homeViewModel.itemModel.value!!.add(ItemViewModel(edt_name.text.toString()))
        })

        homeViewModel.itemModel.observe(homeBiding.lifecycleOwner!!, Observer {
            homeBiding.rvEmployee.adapter?.notifyDataSetChanged()
        })
    }

    override fun OnCLick() {
        Log.d("001", "halo")
    }
}