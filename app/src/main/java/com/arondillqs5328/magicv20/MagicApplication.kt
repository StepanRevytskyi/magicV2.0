package com.arondillqs5328.magicv20

import android.app.Application

class MagicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: MagicApplication
            private set

        var id: Int = -1
    }
}