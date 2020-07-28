package com.example.simplemvvmlogin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemvvmlogin.R
import com.example.simplemvvmlogin.commol.OnClickItem
import com.example.simplemvvmlogin.databinding.ItemRowBinding
import com.example.simplemvvmlogin.viewmodel.HomeViewModel
import com.example.simplemvvmlogin.viewmodel.ItemViewModel

class EmployeeAdapter(var list: HomeViewModel, val lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<EmployeeAdapter.Holder>(), OnClickItem {

    lateinit var homeViewModel: HomeViewModel

    class Holder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setBinding(data: ItemViewModel) {
            binding.itemViewModel = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val context = parent.context
        val binding: ItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.item_row,
            parent,
            false
        )
        binding.lifecycleOwner = lifecycleOwner
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.itemModel.value!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setBinding(list.itemModel.value!![position])

        holder.binding.clicked = this
        homeViewModel = list
    }

    override fun OnCLick() {
        list.onItemClick()
    }
}