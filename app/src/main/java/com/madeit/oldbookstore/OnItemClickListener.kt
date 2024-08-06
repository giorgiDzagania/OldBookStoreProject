package com.madeit.oldbookstore

import android.view.View

interface OnItemClickListener {
    fun onClick(view: View, position: Int)
}