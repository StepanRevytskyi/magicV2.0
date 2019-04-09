package com.arondillqs5328.magicv20.ui.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.androidx.MvpAppCompatFragment

class DetailFragment : MvpAppCompatFragment() {

    private lateinit var buttonBack: ImageView
    private lateinit var buttonFavorite: ImageView
    private lateinit var symbol: TextView
    private lateinit var price: TextView
    private lateinit var label: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        setupView(view)

        return view
    }

    private fun setupView(view: View) {
        buttonBack = view.findViewById(R.id.btn_back)
        buttonBack.setOnClickListener { activity?.onBackPressed() }

        buttonFavorite = view.findViewById(R.id.btn_favorite)

        symbol = view.findViewById(R.id.symbol)
        price = view.findViewById(R.id.price_fa)
        label = view.findViewById(R.id.label_fa)
    }
}