package com.nobel.dhar.offer.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nobel.dhar.offer.persistence.Item
import com.nobel.dhar.offer.ui.food_details.ItemAdapter

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}
@BindingAdapter("setData")
fun RecyclerView.bindDataWithRecycler(data: List<Item>?){
    this.adapter = data?.let { ItemAdapter(it) }
}