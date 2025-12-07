package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class OrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val btnPlaceOrder = view.findViewById<Button>(R.id.btnPlaceOrder)

        btnPlaceOrder.setOnClickListener {
            // 1. İşlem Başarılı Mesajı
            Toast.makeText(context, "Siparişiniz Alındı! Afiyet Olsun 🍔", Toast.LENGTH_LONG).show()

            // 2. Anasayfaya Geri Dön
            // nav_graph'ta popToHome gibi bir ayar yapmadıysak en kolayı:
            // Ana sayfa menü butonuna tıklanmış gibi yapabiliriz veya backstack'i temizleyebiliriz.
            // Şimdilik basitçe 2 kere geri gidelim (Önce sepete, sonra home'a) ya da direkt home ID'sine gidelim.

            findNavController().popBackStack(R.id.HomeFragment, false)
        }

        return view
    }
}