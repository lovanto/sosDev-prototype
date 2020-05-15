package com.lovanto.sosdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_row_users.username

class DetailActivity : AppCompatActivity() {

    private var title: String = "User Detail"

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setActionBarTitle(title)

        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as Data

        name.text = dataUser.name.toString()
        username.text = dataUser.username.toString()
        company.text = dataUser.company.toString()
        location.text = dataUser.location.toString()
        repo.text = dataUser.repository.toString()
        followerss.text = dataUser.followers.toString()
        followings.text = dataUser.following.toString()
        avatars.setImageResource(dataUser.avatar)
    }
}
