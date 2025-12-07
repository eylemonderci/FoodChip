package com.example.foodchip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        // 1. Alt Menüyü Bul
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // 2. Navigasyon Yöneticisini Bul
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        // 3. Birbirine Bağla
        bottomNav.setupWithNavController(navController)

        // 4. YENİ EKLENEN KISIM: Yeniden Seçim (Reselection) Kontrolü
        // Kullanıcı zaten seçili olan bir ikona (Örn: Home) tekrar basarsa burası çalışır.
        bottomNav.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.HomeFragment -> {
                    // Eğer Ana Sayfa ikonuna tekrar basıldıysa,
                    // BurgerFragment vb. sayfaları kapatıp HomeFragment'a geri dön.
                    navController.popBackStack(R.id.HomeFragment, false)
                }
                // Diğer ikonlar için (Sepet vb.) özel bir şey yapmaya gerek yok
            }
        }
    }
}