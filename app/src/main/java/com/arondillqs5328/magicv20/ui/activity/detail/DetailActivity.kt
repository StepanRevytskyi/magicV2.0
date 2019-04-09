package com.arondillqs5328.magicv20.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.ui.fragment.detail.DetailFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)

        savedInstanceState ?: supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_frame_layout, DetailFragment())
            .commit()
    }
}
