package com.lovanto.sosdev

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_row_users.*
import kotlinx.android.synthetic.main.item_row_users.username

class DetailActivity : AppCompatActivity(){

    private var title: String = "User Detail"

    companion object{
        const val EXTRA_DATA = "extra_data"
//        const val EXTRA_NAME = "extra_name"
//        const val EXTRA_USERNAME = "extra_username"
//        const val EXTRA_AVATAR = "extra_avatar"
//        const val EXTRA_COMPANY = "extra_company"
//        const val EXTRA_LOCATION = "extra_location"
//        const val EXTRA_REPOSITORY = "extra_repository"
//        const val EXTRA_FOLLOWERS = "extra_followers"
//        const val EXTRA_FOLLOWING = "extra_following"
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

//        val nametxt = intent.getStringExtra(EXTRA_NAME)
//        val usernametxt = intent.getStringExtra(EXTRA_USERNAME)
//        val locationtxt = intent.getStringExtra(EXTRA_LOCATION)
//        val companytxt = intent.getStringExtra(EXTRA_COMPANY)
//        val repositorytxt = intent.getStringExtra(EXTRA_REPOSITORY)
//        val followerstxt = intent.getStringExtra(EXTRA_FOLLOWERS)
//        val followingtxt = intent.getStringExtra(EXTRA_FOLLOWING)
//        val avatarimg = intent.getIntExtra(EXTRA_AVATAR, 0)

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
