package com.example.testapp.repository

import com.example.testapp.model.CuisineType
import com.example.testapp.model.DishesList
import com.example.testapp.R

class DataRepository {

    fun getCuisineList() = mutableListOf<CuisineType>().apply {
        add(CuisineType(R.drawable.ic_indian_cuisine, "Indian", getIndianCuisine()))
        add(CuisineType(R.drawable.ic_chinese_cuisine, "Chinese", getChineseCuisine()))
        add(CuisineType(R.drawable.ic_french_cuisine, "Italian", getItalianCuisine()))
    }

    fun getIndianCuisine() = arrayListOf<DishesList>().apply {
        add(DishesList(R.drawable.ic_indian_food, "Chhole Bhature"))
        add(DishesList(R.drawable.ic_indian_food, "Samosa"))
        add(DishesList(R.drawable.ic_indian_food, "Jalebi"))
        add(DishesList(R.drawable.ic_indian_food, "Kulche"))
        add(DishesList(R.drawable.ic_indian_food, "Undhiyo"))
        add(DishesList(R.drawable.ic_indian_food, "Aloo Parantha"))
        add(DishesList(R.drawable.ic_indian_food, "Rosogolla"))
        add(DishesList(R.drawable.ic_indian_food, "Butter Chicken"))
        add(DishesList(R.drawable.ic_indian_food, "Pav Bhaji"))
        add(DishesList(R.drawable.ic_indian_food, "Shahi paneer"))
        add(DishesList(R.drawable.ic_indian_food, "Masala Dosar"))
        add(DishesList(R.drawable.ic_indian_food, "Khakhra"))
    }

    fun getChineseCuisine() = arrayListOf<DishesList>().apply {
        add(DishesList(R.drawable.ic_chinese_food, "Veg Hakka Noodles"))
        add(DishesList(R.drawable.ic_chinese_food, "Manchurian"))
        add(DishesList(R.drawable.ic_chinese_food, "Vegetable Fried Rice"))
        add(DishesList(R.drawable.ic_chinese_food, "Szechwan Chilli Chicken"))
        add(DishesList(R.drawable.ic_chinese_food, "Spring Rolls"))
        add(DishesList(R.drawable.ic_chinese_food, " Honey Chilli Potato"))
        add(DishesList(R.drawable.ic_chinese_food, "Quick Noodles"))
        add(DishesList(R.drawable.ic_chinese_food, "Mushroom Manchurian"))
        add(DishesList(R.drawable.ic_chinese_food, "Stir Fried Tofu with Rice"))
        add(DishesList(R.drawable.ic_chinese_food, " Vegetable Manchow Soup"))
    }

    fun getItalianCuisine() = arrayListOf<DishesList>().apply {
        add(DishesList(R.drawable.ic_italian_food, "Pasta"))
        add(DishesList(R.drawable.ic_italian_food, "pizza"))
        add(DishesList(R.drawable.ic_italian_food, "Napoletana Pizza "))
        add(DishesList(R.drawable.ic_italian_food, "Risotto"))
        add(DishesList(R.drawable.ic_italian_food, "Lasagne"))
        add(DishesList(R.drawable.ic_italian_food, "Polenta"))
        add(DishesList(R.drawable.ic_italian_food, "Gelato"))

    }

}