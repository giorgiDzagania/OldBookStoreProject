package com.madeit.oldbookstore

import android.view.View

interface ItemClickListener {
    fun onClickPaid(view: View, position: Int)
    fun onClickFree(view: View, position: Int)
}