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
import com.madeit.oldbookstore.model.ModelDonations
import com.squareup.picasso.Picasso

class DonationsAdapter(
    private val mContext: Context,
    private val mActivity: Activity,
    private val mContentList: ArrayList<ModelDonations>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private var clickListener: ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.free, parent, false)
        return ViewHolder(view)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        clickListener = itemClickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val cardView: CardView = itemView.findViewById(R.id.free_cardView)
        val imageUri: ImageView = itemView.findViewById(R.id.image_free)
        val bookTitle: TextView = itemView.findViewById(R.id.book_title_free)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener?.onClickFree(view, adapterPosition)
        }
    }

    override fun onBindViewHolder(mainHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = mainHolder as ViewHolder
        val model = mContentList[position]

        // Setting data over views
        val imgUrl = model.imageUri
        Log.d("myApp", imgUrl.toString())
        if (!imgUrl.isNullOrEmpty()) {
            Picasso.get().load(imgUrl).fit().into(holder.imageUri)
        }
        holder.bookTitle.text = model.book_title
    }

    override fun getItemCount(): Int {
        return mContentList.size
    }
}