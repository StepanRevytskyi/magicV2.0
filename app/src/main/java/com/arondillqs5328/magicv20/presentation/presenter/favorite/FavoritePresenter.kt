package com.arondillqs5328.magicv20.presentation.presenter.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arondillqs5328.magicv20.database.DatabaseHelper
import com.arondillqs5328.magicv20.model.pojo.Data
import com.arondillqs5328.magicv20.model.pojo.Quote
import com.arondillqs5328.magicv20.model.pojo.USD
import com.arondillqs5328.magicv20.presentation.view.favorite.FavoriteView

@InjectViewState
class FavoritePresenter : MvpPresenter<FavoriteView>() {

    private var liveData: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    private var databaseHelper: DatabaseHelper = DatabaseHelper()

    init {
        val data: ArrayList<Data> = ArrayList()
        this.liveData.value = data
    }

    fun getLiveData(): LiveData<ArrayList<Data>> = liveData

    fun onLoadData() {
        viewState.showProgressBar()

        //liveData.value = databaseHelper.getFavoritesCryptocurrency().value
        liveData.value = arrayListOf(
            Data(1, "Bitcoin", Quote(USD(1212.0))),
            Data(2, "dasda", Quote(USD(1212.0))),
            Data(3, "bidsadasdin", Quote(USD(1212.0))),
            Data(4, "bitdasn", Quote(USD(1212.0))),
            Data(5, "dsadcoin", Quote(USD(1212.0))),
            Data(6, "dcoin", Quote(USD(1212.0))),
            Data(68, "dcoin", Quote(USD(1212.0))),
            Data(665, "dcoin", Quote(USD(1212.0))),
            Data(62, "dcoin", Quote(USD(1212.0))),
            Data(61, "dcoin", Quote(USD(1212.0))),
            Data(63, "dcoin", Quote(USD(1212.0))),
            Data(64, "dcoin", Quote(USD(1212.0))),
            Data(65, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(67, "dcoin", Quote(USD(1212.0))),
            Data(70, "dsain", Quote(USD(1212.0)))
        )

        viewState.hideProgressBar()
    }

    fun onDelete(id: Int) {
        databaseHelper.deleteCryptocurrencyById(id)
    }
}