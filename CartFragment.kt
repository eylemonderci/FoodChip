package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController

class CartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCartList)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Sepet listesi
        val sepetListesi = ArrayList<FoodModel>()
        sepetListesi.add(FoodModel(R.drawable.cheese_burger, "Cheeseburger", "180 ₺", 4.5))
        sepetListesi.add(FoodModel(R.drawable.americano, "Americano", "40 ₺", 4.1))

        // FoodAdapter'ın sepet modu aktif
        val adapter = FoodAdapter(sepetListesi, isCart = true)
        recyclerView.adapter = adapter

        // Sepeti onayla butonu
        val btnConfirm = view.findViewById<Button>(R.id.btnConfirmCart)
        btnConfirm.setOnClickListener {
            // Fragment'ten güvenli navigasyon
            findNavController().navigate(R.id.action_cartFragment_to_orderFragment)
        }

        return view
    }
}
