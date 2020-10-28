package com.nobel.dhar.offer.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nobel.dhar.offer.BR
import com.nobel.dhar.offer.R
import com.nobel.dhar.offer.databinding.FoodRowBinding
import com.nobel.dhar.offer.persistence.Food
import com.nobel.dhar.offer.persistence.FoodWithItems

class FoodAdapter (val foodList: List<FoodWithItems>, val listener: CustomClickListener):
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    private val TAG: String? = FoodAdapter::class.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.MyViewHolder {
        var binding = DataBindingUtil.inflate<FoodRowBinding>(LayoutInflater.from(parent.context), R.layout.food_row, parent, false)
        return MyViewHolder(binding,listener)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodAdapter.MyViewHolder, position: Int) {
        var currentFood = foodList.get(position)
        holder.bind(currentFood.food)
    }
    inner class MyViewHolder(val binding: FoodRowBinding, val listener: CustomClickListener) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.listener=listener
        }

        fun bind(any: Any) {
            binding.setVariable(BR.model, any)
            binding.executePendingBindings();
        }

    }
}