package com.lovanto.sosdev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
//        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
//        intentDetail.putExtra(DetailActivity.EXTRA_NAMA, data.namePlace.toString())
//        intentDetail.putExtra(DetailActivity.EXTRA_LOKASI, data.lokasiPlace.toString())
//        intentDetail.putExtra(DetailActivity.EXTRA_DETAIL, data.detailPlace.toString())
//        intentDetail.putExtra(DetailActivity.EXTRA_NOMOR, data.callPlace.toString())
//        intentDetail.putExtra(DetailActivity.EXTRA_FOTO, data.image)
//        startActivity(intentDetail)
    }
}
