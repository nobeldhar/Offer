package com.nobel.dhar.offer.ui.home

import com.nobel.dhar.offer.data.local.entities.Food

interface CustomClickListener {
    fun onFoodSelected(food: Food)
}