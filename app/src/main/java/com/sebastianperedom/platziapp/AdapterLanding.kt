package com.sebastianperedom.platziapp

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_landing.view.*

/**
 * Created by Sebastian on 10/12/2017.
 */

class AdapterLanding(val data: List<ItemLanding>): RecyclerView.Adapter<AdapterLanding.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
        Holder(parent?.inflate(R.layout.item_landing))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        fun bindView(itemLanding: ItemLanding) {
            with(itemLanding) {
                itemView.txtTitleItem.text = title
                itemView.txtDescItem.text  = desc
                itemView.txtNroItem.text   = "Nro $nro"

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("title", title)
                    intent.putExtra("desc" , desc)
                    intent.putExtra("nro"  , nro)

                    val p1:Pair<View, String> = Pair.create(itemView.imgHeaderItem, "transitionHeader")
                    val p2:Pair<View, String> = Pair.create(itemView.txtTitleItem , "transitionTitle")
                    val p3:Pair<View, String> = Pair.create(itemView.txtDescItem  , "transitionDesc")
                    val p4:Pair<View, String> = Pair.create(itemView.txtNroItem   , "transitionNro")
                    val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)

                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }
}