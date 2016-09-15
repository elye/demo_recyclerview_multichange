package com.elyeproj.recycleranimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        adapter = MyViewAdapter()
        myRecyclerView.adapter = adapter

        myRecyclerView.layoutManager = object : LinearLayoutManager(this) {
            override fun supportsPredictiveItemAnimations(): Boolean {
                return true
            }
        }
        myRecyclerView.layoutManager.supportsPredictiveItemAnimations()
        restoreOriginalList()

        btn_restore.setOnClickListener { restoreOriginalList() }
        btn_random.setOnClickListener { removeEventItemList() }
    }

    private fun removeEventItemList() {
        val tmp_item = arrayListOf<Int>()

        for (i in 1 .. 100) {
            if (Math.random() > 0.5)
                tmp_item.add(i)
        }
        adapter.itemList = tmp_item
    }

    private fun restoreOriginalList() {
        val itemList = arrayListOf<Int>()

        for (i in 1 .. 100) {
            itemList.add(i)
        }
        adapter.itemList = itemList
    }
}
