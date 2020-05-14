package com.lovanto.sosdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Data> = ArrayList()
    private var title: String = "Github User's"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)

        recycleView.setHasFixedSize(true)
        recycleView.addItemDecoration(
            DividerItemDecoration(
                recycleView.getContext(),
                DividerItemDecoration.HORIZONTAL
            )
        )

        list.addAll(DataValue.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    private fun showRecyclerList(){
        recycleView.layoutManager = LinearLayoutManager(this)
        val listDataAdapter = ListDataAdapter(list)
        recycleView.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object : ListDataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Data) {
                showSelectedData(data)
            }
        })
    }

    private fun showSelectedData(data: Data) {
        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetail.putExtra(DetailActivity.EXTRA_NAME, data.name)
        intentDetail.putExtra(DetailActivity.EXTRA_USERNAME, data.username)
        intentDetail.putExtra(DetailActivity.EXTRA_COMPANY, data.company)
        intentDetail.putExtra(DetailActivity.EXTRA_LOCATION, data.location)
        intentDetail.putExtra(DetailActivity.EXTRA_REPOSITORY, data.repository.toString())
        intentDetail.putExtra(DetailActivity.EXTRA_FOLLOWERS, data.followers.toString())
        intentDetail.putExtra(DetailActivity.EXTRA_FOLLOWING, data.following.toString())
        intentDetail.putExtra(DetailActivity.EXTRA_AVATAR, data.avatar)
        startActivity(intentDetail)
    }
}
