package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DessertFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dessert, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvDessertList)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        // TATLI LİSTESİ
        val tatliListesi = ArrayList<FoodModel>()

        // DİKKAT: Puanlar tırnaksız (Sayı)
        tatliListesi.add(FoodModel(R.drawable.cilekli_pasta, "Çilekli Pasta", "120 ₺", 4.9))
        tatliListesi.add(FoodModel(R.drawable.sufle, "Sufle", "100 ₺", 4.8))
        tatliListesi.add(FoodModel(R.drawable.waffle, "Waffle", "150 ₺", 4.5))
        tatliListesi.add(FoodModel(R.drawable.baklava, "Baklava", "250 ₺", 5.0))
        tatliListesi.add(FoodModel(R.drawable.sutlac, "Sütlaç", "80 ₺", 4.2))

        val adapter = FoodAdapter(tatliListesi, true)
        recyclerView.adapter = adapter

        return view
    }
}