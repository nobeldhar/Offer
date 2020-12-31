package com.nobel.dhar.offer.persistence.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nobel.dhar.offer.persistence.entities.Item

class FoodConverter {
    @TypeConverter
    fun fromStringToItem(value: String): Item? {
        val listType = object : TypeToken<Item>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringToItemList(value: String): List<Item>? {
        val listType = object : TypeToken<List<Item>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromItemToString(info: Item): String {
        val gson = Gson()
        return gson.toJson(info)
    }

    @TypeConverter
    fun fromItemListToString(infos: List<Item>): String {
        val gson = Gson()
        return gson.toJson(infos)
    }
}