package com.arondillqs5328.magicv20.ui.fragment.cryptocurrency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.androidX.MvpAppCompatFragment

class CryptocurrencyFragment : MvpAppCompatFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_cryptocurrency, container, false)

        return view
    }
}