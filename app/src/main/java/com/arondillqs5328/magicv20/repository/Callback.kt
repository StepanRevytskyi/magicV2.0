package com.arondillqs5328.magicv20.repository

import com.arondillqs5328.magicv20.model.pojo.Data

interface Callback {

    fun onSuccess(data: List<Data>)

    fun onFailed()

}