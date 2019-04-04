package com.arondillqs5328.magicv20.repository.cryptocurrency

interface Repository {

    fun loadMore(start: Int, limit: Int)

}