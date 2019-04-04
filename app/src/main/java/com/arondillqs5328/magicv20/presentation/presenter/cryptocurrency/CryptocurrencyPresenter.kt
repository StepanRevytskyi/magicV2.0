package com.arondillqs5328.magicv20.presentation.presenter.cryptocurrency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arondillqs5328.magicv20.model.pojo.Data
import com.arondillqs5328.magicv20.network.APIServise
import com.arondillqs5328.magicv20.presentation.view.cryptocurrency.CryptoView
import com.arondillqs5328.magicv20.repository.cryptocurrency.Callback
import com.arondillqs5328.magicv20.repository.cryptocurrency.CryptocurrencyRepository

@InjectViewState
class CryptocurrencyPresenter : MvpPresenter<CryptoView>(), Callback {

    private var isLoading: Boolean = false
    private var start: Int = 1
    private var limit: Int = 25
    private var liveData: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    private val repository: CryptocurrencyRepository = CryptocurrencyRepository(APIServise().createAPI(), this)

    init {
        val data: ArrayList<Data> = ArrayList()
        this.liveData.value = data
    }

    fun getLiveData(): LiveData<ArrayList<Data>> = liveData

    fun onLoadMore(position: Int, count: Int) {
        if (position == count - 1) {
            if (liveData.value?.size ?: 0 == 0) {
                if (!isLoading) {
                    viewState.showProgressBar()
                    isLoading = true
                    repository.loadMore(start, limit)
                }
            } else {
                if (!isLoading) {
                    viewState.showFooter(true)
                    isLoading = true
                    repository.loadMore(start, limit)
                }
            }
        }
    }

    fun onSaveToDatabase(data: Data) {
        //TODO: it must do DatabaseHelper
    }

    override fun onSuccess(data: List<Data>) {
        fun updateParams() {
            start += limit
            isLoading = false
        }

        val oldData: ArrayList<Data>? = liveData.value
        oldData?.addAll(data)

        liveData.value = oldData
        updateParams()

        viewState.hideProgressBar()
        viewState.hideFooter()
    }

    override fun onFailed() {
        //TODO: not implemented
    }
}