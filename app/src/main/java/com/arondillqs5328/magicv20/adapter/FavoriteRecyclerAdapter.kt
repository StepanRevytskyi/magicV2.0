package com.arondillqs5328.magicv20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.model.pojo.Data
import com.squareup.picasso.Picasso

class FavoriteRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: ArrayList<Data> = ArrayList()

    fun setupData(data: ArrayList<Data>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.favorite_item, parent, false
        )
        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FavoriteViewHolder -> {
                holder.bind(data[position])
            }
        }
    }

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var url: String = "https://s2.coinmarketcap.com/static/img/coins/128x128/"

        private val icon: ImageView = itemView.findViewById(R.id.icon_fa)
        private val label: TextView = itemView.findViewById(R.id.label_fa)

        fun bind(data: Data) {
            Picasso.get().load(url + data.id + ".png").into(icon)
            label.text = data.name
        }
    }
}