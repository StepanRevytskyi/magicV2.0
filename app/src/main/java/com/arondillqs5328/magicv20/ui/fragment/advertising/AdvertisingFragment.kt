package com.arondillqs5328.magicv20.ui.fragment.advertising

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.androidx.MvpAppCompatFragment

class AdvertisingFragment : MvpAppCompatFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_advertising, container, false)

        println("adver create")
        return view
    }
}