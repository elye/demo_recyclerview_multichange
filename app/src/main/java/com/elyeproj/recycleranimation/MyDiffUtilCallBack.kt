package com.elyeproj.recycleranimation

import android.support.v7.util.DiffUtil
import java.util.*

class MyDiffUtilCallBack(val oldList: ArrayList<Int>?, val newList: ArrayList<Int>?) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList?.get(newItemPosition)?.equals(oldList?.get(oldItemPosition))!!
    }

    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList?.get(newItemPosition)?.equals(oldList?.get(oldItemPosition))!!
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
