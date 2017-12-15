package com.sebastianperedom.platziapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Sebastian on 10/12/2017.
 */

class DBOpenHelper(ctx: Context): ManagedSQLiteOpenHelper(ctx, "noticias", null, 1) {

    companion object {
        private var instance: DBOpenHelper? = null

        fun getInstance(ctx: Context): DBOpenHelper? =
            if(instance == null) {
                instance = DBOpenHelper(ctx)
                instance
            } else {
                instance
            }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val id    = "id"    to INTEGER + PRIMARY_KEY
        val img   = "img"   to BLOB
        val title = "title" to TEXT
        val desc  = "desc"  to TEXT
        val nro   = "nro"   to TEXT

        db?.createTable("Noticias", true, id, img, title, desc, nro)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val Context.database: DBOpenHelper?
        get() = getInstance(applicationContext)
}