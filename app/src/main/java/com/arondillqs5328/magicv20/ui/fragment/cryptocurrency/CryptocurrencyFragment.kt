package com.arondillqs5328.magicv20.ui.fragment.cryptocurrency

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arondillqs5328.magicv20.MagicApplication
import com.arondillqs5328.magicv20.R
import com.arondillqs5328.magicv20.adapter.BasicRecyclerAdapter
import com.arondillqs5328.magicv20.adapter.CryptocurrencyRecyclerAdapter
import com.arondillqs5328.magicv20.androidx.MvpAppCompatFragment
import com.arondillqs5328.magicv20.model.pojo.Data
import com.arondillqs5328.magicv20.model.pojo.Quote
import com.arondillqs5328.magicv20.model.pojo.USD
import com.arondillqs5328.magicv20.presentation.presenter.cryptocurrency.CryptocurrencyPresenter
import com.arondillqs5328.magicv20.presentation.view.cryptocurrency.CryptoView
import com.arondillqs5328.magicv20.ui.activity.detail.DetailActivity

class CryptocurrencyFragment : MvpAppCompatFragment(), CryptoView, BasicRecyclerAdapter.OnItemClickListener {

    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar

    @InjectPresenter
    lateinit var presenter: CryptocurrencyPresenter

    private lateinit var data: LiveData<ArrayList<Data>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_cryptocurrency, container, false)

        recycler = view.findViewById(R.id.crypto_recycler_view)
        progressBar = view.findViewById(R.id.crypto_progress_bar)
        data = presenter.getLiveData()

        setupRecyclerView()
        setupLiveData()

        savedInstanceState ?: presenter.onLoadMore(
            (recycler.layoutManager as LinearLayoutManager).findLastVisibleItemPosition(),
            (recycler.layoutManager as LinearLayoutManager).itemCount
        )

        return view
    }

    private fun setupRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recycler.adapter = CryptocurrencyRecyclerAdapter(this)
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                presenter.onLoadMore(
                    (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition(),
                    (recyclerView.layoutManager as LinearLayoutManager).itemCount
                )
            }
        })
    }

    private fun setupLiveData() {
        data.observe(this, Observer<ArrayList<Data>> { data ->
            (recycler.adapter as CryptocurrencyRecyclerAdapter).setupData(data, false)
        })
    }

    override fun showProgressBar() {
        recycler.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
        recycler.visibility = View.VISIBLE
    }

    override fun showFooter(isLoading: Boolean) {
        val oldData: ArrayList<Data>? = data.value
        oldData?.add(Data(-1, "", Quote(USD(-1.0))))
        oldData?.let { (recycler.adapter as CryptocurrencyRecyclerAdapter).setupData(it, true) }
    }

    override fun hideFooter() {
        val oldData: ArrayList<Data>? = data.value
        oldData?.let { (recycler.adapter as CryptocurrencyRecyclerAdapter).setupData(it, false) }
    }

    override fun onItemClick(id: Int) {
        MagicApplication.id = id
        startActivity(Intent(activity, DetailActivity::class.java))
    }
}