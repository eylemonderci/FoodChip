package com.example.foodchip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Tasarımı yüklüyoruz
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Burger Kutusunu Bul
        // Eğer XML'de ID'si farklıysa hata verir, kontrol et: cardBurgerNav
        try {
            val cardBurger = view.findViewById<CardView>(R.id.cardBurgerNav)
            cardBurger.setOnClickListener {
                // Burger sayfasına git
                try {
                    findNavController().navigate(R.id.action_HomeFragment_to_BurgerFragment)
                } catch (e: Exception) {
                    Toast.makeText(context, "Navigasyon oku bulunamadı!", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            // Eğer cardBurgerNav bulunamazsa uygulama çökmesin diye önlem
        }

        // 2. Tatlı Kutusunu Bul
        try {
            val cardTatli = view.findViewById<CardView>(R.id.cardTatliNav)
            cardTatli.setOnClickListener {
                // Tatlı sayfası ve oku varsa burayı aç:
                // findNavController().navigate(R.id.action_homeFragment_to_tatliFragment)
                Toast.makeText(context, "Tatlılar yakında...", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) { }

        // 3. İçecek Kutusunu Bul
        try {
            val cardIcecek = view.findViewById<CardView>(R.id.cardIcecekNav)
            cardIcecek.setOnClickListener {
                Toast.makeText(context, "İçecekler yakında...", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) { }

        // 1. Burger Kutusuna Tıklama
        view.findViewById<CardView>(R.id.cardBurgerNav).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_BurgerFragment)
        }

        // 2. Tatlı Kutusuna Tıklama
        view.findViewById<CardView>(R.id.cardTatliNav).setOnClickListener {
            // NavGraph'taki ok ismini kontrol et
            findNavController().navigate(R.id.action_HomeFragment_to_dessertFragment)
        }

        // 3. İçecek Kutusuna Tıklama (Eğer Home XML'de eklediysen)
        // XML'de cardIcecekNav id'li bir kutu eklediysen bu kodu aç:

        view.findViewById<CardView>(R.id.cardIcecekNav).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_drinkFragment)
        }
    }
    }
