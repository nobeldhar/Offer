package com.nobel.dhar.offer.ui.home

import com.nobel.dhar.offer.persistence.entities.Food

interface CustomClickListener {
    fun onFoodSelected(food: Food)
}