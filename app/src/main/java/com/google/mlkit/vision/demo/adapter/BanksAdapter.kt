package com.google.mlkit.vision.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.dataclass.BanksItem

class BanksAdapter () :
    RecyclerView.Adapter<BanksAdapter.RestroViewHolder>() {

    var restro = mutableListOf<BanksItem>()

    class RestroViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val description : TextView = itemView.findViewById(R.id.desc)
        val rating : TextView = itemView.findViewById(R.id.rating)
        val price : TextView = itemView.findViewById(R.id.price)
        val image : ImageView = itemView.findViewById(R.id.restroimg)
        val location : TextView = itemView.findViewById(R.id.location)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestroViewHolder {
        return RestroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recitemview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RestroViewHolder, position: Int) {
        val restro = restro[position]
        holder.name.text = restro.Name
        holder.description.text = "${restro.Description}"
        holder.rating.text = "${restro.Rating.toString()}"
        holder.price.text ="${ restro.Price.toString()}"
        holder.location.text = "${restro.Location}"
        Glide.with(holder.image)
            .load(restro.Image)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return restro.size
    }

    @JvmName("setRestro1")
    fun setRestro(restro : List<BanksItem>) {
        this.restro = restro.toMutableList()
        notifyDataSetChanged()
    }

}