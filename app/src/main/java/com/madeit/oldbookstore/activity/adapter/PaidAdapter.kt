package com.madeit.oldbookstore.activity.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.madeit.oldbookstore.ItemClickListener
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.model.ModelPaid
import com.squareup.picasso.Picasso

class PaidAdapter(
    private val mContext: Context,
    private val mActivity: Activity,
    private val mContentList: ArrayList<ModelPaid>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private var clickListener: ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.paid, parent, false)
        return ViewHolder(view, viewType)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        clickListener = itemClickListener
    }

    class ViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val cardView: CardView = itemView.findViewById(R.id.paid_cardView)
        val imageUri: ImageView = itemView.findViewById(R.id.image_paid)
        val bookTitle: TextView = itemView.findViewById(R.id.book_title_paid)
        val price: TextView = itemView.findViewById(R.id.price_paid)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener?.onClickPaid(view, adapterPosition)
        }
    }

    override fun onBindViewHolder(mainHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = mainHolder as ViewHolder
        val model = mContentList[position]
        // setting data over views
        val imgUrl = model.imageUri
        Log.d("myApp", imgUrl.toString())
        if (!imgUrl.isNullOrEmpty()) {
            Picasso.get().load(imgUrl).fit().into(holder.imageUri)
        }
        holder.bookTitle.text = model.book_title
        holder.price.text = model.price
    }

    override fun getItemCount(): Int {
        return mContentList.size
    }
}