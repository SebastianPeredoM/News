package com.sebastianperedom.platziapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rcViewLanding.layoutManager = GridLayoutManager(this,2)

        val itemsShop = (0..20).map {
            val nro = it + 1
            ItemLanding("Noticia $nro", "Breve descripción $nro", nro)
        }

        val adapter = AdapterLanding(itemsShop)
        rcViewLanding.adapter = adapter
    }
}
