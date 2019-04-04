package com.arondillqs5328.magicv20.model.pojo

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Data(
    @PrimaryKey
    var id: Int = -1,

    var name: String = "",

    @Ignore
    var quote: Quote? = null
)