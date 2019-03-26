package com.arondillqs5328.magicv20.ui.fragment.favotite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.androidX.MvpAppCompatFragment

class FavoriteFragment : MvpAppCompatFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_favorite, container, false)

        return view
    }
}