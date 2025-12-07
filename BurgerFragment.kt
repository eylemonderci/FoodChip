package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BurgerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_burger, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvBurgerList)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val list = ArrayList<FoodModel>()
        list.add(FoodModel(R.drawable.cheese_burger, "Cheese Burger", "180 ₺", 4.5))
        list.add(FoodModel(R.drawable.barbeku_burger, "Barbekü Burger", "200 ₺", 4.7))
        list.add(FoodModel(R.drawable.tavuk_burger, "Tavuk Burger", "150 ₺", 4.2))
        list.add(FoodModel(R.drawable.vegan_burger, "Vegan Burger", "190 ₺", 3.8))
        list.add(FoodModel(R.drawable.kasap_burger, "Kasap Burger", "220 ₺", 5.0))
        list.add(FoodModel(R.drawable.mini_burger, "Mini Burger", "120 ₺", 3.5))

        // Burada sepet modunu false yapıyoruz çünkü bu sadece kategori listesi
        val adapter = FoodAdapter(list, isCart = false)
        recyclerView.adapter = adapter

        return view
    }
}
