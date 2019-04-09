package com.arondillqs5328.magicv20.ui.fragment.favotite

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
import com.arondillqs5328.magicv20.adapter.FavoriteRecyclerAdapter
import com.arondillqs5328.magicv20.androidx.MvpAppCompatFragment
import com.arondillqs5328.magicv20.model.pojo.Data
import com.arondillqs5328.magicv20.presentation.presenter.favorite.FavoritePresenter
import com.arondillqs5328.magicv20.presentation.view.favorite.FavoriteView
import com.arondillqs5328.magicv20.ui.activity.detail.DetailActivity

class FavoriteFragment : MvpAppCompatFragment(), FavoriteView, BasicRecyclerAdapter.OnItemClickListener {

    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar

    @InjectPresenter
    lateinit var presenter: FavoritePresenter

    private lateinit var data: LiveData<ArrayList<Data>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_favorite, container, false)

        recycler = view.findViewById(R.id.favorite_recycler_view)
        progressBar = view.findViewById(R.id.favorite_progress_bar)
        data = presenter.getLiveData()

        setupRecyclerView()
        setupLiveData()

        savedInstanceState ?: presenter.onLoadData()

        return view
    }

    private fun setupRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recycler.adapter = FavoriteRecyclerAdapter(this)
    }

    private fun setupLiveData() {
        data.observe(this, Observer<ArrayList<Data>> { data ->
            (recycler.adapter as FavoriteRecyclerAdapter).setupData(data)
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

    override fun onItemClick(id: Int) {
        MagicApplication.id = id
        startActivity(Intent(activity, DetailActivity::class.java))
    }
}