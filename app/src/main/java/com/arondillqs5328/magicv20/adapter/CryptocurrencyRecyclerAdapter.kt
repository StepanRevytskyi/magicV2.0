package com.arondillqs5328.magicv20.adapter

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.model.pojo.Data
import com.squareup.picasso.Picasso

class CryptocurrencyRecyclerAdapter : BasicRecyclerAdapter() {

    private var data: ArrayList<Data>? = ArrayList()
    private var isLoading = false

    fun setupData(data: ArrayList<Data>?) {
        isLoading = false
        this.data = data
        Handler().postDelayed({
            notifyDataSetChanged()
        }, 500)
    }

    fun setupFooter(data: ArrayList<Data>?, isLoading: Boolean) {
        this.data = data
        this.isLoading = isLoading
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var holder: RecyclerView.ViewHolder

        when (viewType) {
            ITEM_VIEW_TYPE_BASIC -> {
                val view: View = LayoutInflater.from(parent.context).inflate(
                    R.layout.cryptocurrency_item, parent, false
                )
                holder = CryptocurrencyViewHolder(view)
            }
            ITEM_VIEW_TYPE_FOOTER -> {
                val view: View = LayoutInflater.from(parent.context).inflate(
                    R.layout.progress_bar, parent, false
                )
                holder = ProgressBarViewHolder(view)
            }
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return if (data?.get(position)?.id ?: 0 != -1) {
            ITEM_VIEW_TYPE_BASIC
        } else {
            ITEM_VIEW_TYPE_FOOTER
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CryptocurrencyViewHolder -> {
                holder.bind(data?.get(position))
            }
            is ProgressBarViewHolder -> {
                if (isLoading) {
                    holder.progressBar.visibility = View.VISIBLE
                } else {
                    holder.progressBar.visibility = View.GONE
                }
            }
        }
    }

    class CryptocurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var url: String = "https://s2.coinmarketcap.com/static/img/coins/128x128/"

        private val icon: ImageView = itemView.findViewById(R.id.icon)
        private val label: TextView = itemView.findViewById(R.id.label)
        private val price: TextView = itemView.findViewById(R.id.price)

        fun bind(data: Data?) {
            val price: String = "$ ${data!!.quote.usd.price}"

            Picasso.get().load(url + data.id + ".png").into(icon)
            label.text = data.name
            this.price.text = price
        }
    }
}