package com.sebastianperedom.platziapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_description.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            txtTitleDetail.text = it.getString("title")
            txtDescDetail.text  = it.getString("desc")
            txtNroDetail.text   = it.getInt("nro").toString()
        }
    }
}
