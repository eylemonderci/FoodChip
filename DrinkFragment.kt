package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DrinkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_drink, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvDrinkList)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val icecekListesi = ArrayList<FoodModel>()
        icecekListesi.add(FoodModel(R.drawable.su, "Su", "40 ₺", 4.1))
        icecekListesi.add(FoodModel(R.drawable.americano, "Americano", "20 ₺", 4.5))
        icecekListesi.add(FoodModel(R.drawable.latte, "Latte", "50 ₺", 4.3))
        icecekListesi.add(FoodModel(R.drawable.turk_kahvesi, "Türk Kahvesi", "80 ₺", 4.7))
        icecekListesi.add(FoodModel(R.drawable.cold_brew, "Cold Brew", "10 ₺", 5.0))

        val adapter = FoodAdapter(icecekListesi, true)
        recyclerView.adapter = adapter

        return view
    }
}
