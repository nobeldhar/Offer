package com.nobel.dhar.offer.ui.food_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nobel.dhar.offer.BR
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.databinding.ItemColumnBinding
import com.nobel.dhar.offer.data.local.entities.Item

class ItemAdapter(val itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemColumnBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_column, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var item = itemList.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(val binding: ItemColumnBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(any: Any){
            binding.setVariable(BR.model, any)
            binding.executePendingBindings()
        }
    }
}