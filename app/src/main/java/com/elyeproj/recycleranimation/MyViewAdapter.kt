package com.elyeproj.recycleranimation

import android.graphics.Color
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.viewholder.view.*
import java.util.*

class MyViewAdapter : RecyclerView.Adapter<MyViewAdapter.MyViewHolder>(){

    var itemList : ArrayList<Int>? = null
    set(value) {
        val diffResult = DiffUtil.calculateDiff(MyDiffUtilCallBack(itemList, value))
        field = value
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.viewholder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.populate(itemList?.get(position) ?: -1)
    }

    override fun getItemCount() = itemList?.size ?: 0

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var item: Int = 0

        init {
            view.setOnClickListener {  }
        }

        fun populate(item: Int) {
            this.item = item
            view.txt.text = item.toString()

            var color = 0
            when {
                item % 5 == 0 -> color = Color.parseColor("#EEEEEE")
                item % 5 == 1 -> color = Color.parseColor("#FF8888")
                item % 5 == 2 -> color = Color.parseColor("#88FF88")
                item % 5 == 3 -> color = Color.parseColor("#8888FF")
                item % 5 == 4 -> color = Color.parseColor("#888888")
            }
            view.container.setBackgroundColor(color)
        }
    }
}