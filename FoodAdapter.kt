package com.example.foodchip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private var foodList: ArrayList<FoodModel>, isCart: Boolean) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFood: ImageView = itemView.findViewById(R.id.imgFood)
        val tvFoodName: TextView = itemView.findViewById(R.id.tvFoodName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val btnAddCart: ImageView = itemView.findViewById(R.id.btnAddCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_card, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foodList[position]

        holder.imgFood.setImageResource(item.image)
        holder.tvFoodName.text = item.name
        holder.tvPrice.text = item.price
        holder.tvRating.text = item.rating.toString()
        holder.ratingBar.rating = item.rating.toFloat()

        holder.btnAddCart.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${item.name} sepete eklendi!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun filterList(filteredList: ArrayList<FoodModel>) {
        foodList = filteredList
        notifyDataSetChanged()
    }
}
