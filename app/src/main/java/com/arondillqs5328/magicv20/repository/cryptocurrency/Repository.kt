package com.arondillqs5328.magicv20.repository.cryptocurrency

import com.arondillqs5328.magicv20.model.pojo.Data

interface Repository {

    fun loadMore(start: Int, limit: Int)

    fun saveToDatabase(data: Data)
}