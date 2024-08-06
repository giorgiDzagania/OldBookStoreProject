package com.madeit.oldbookstore.activity.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.ChatActivity
import com.madeit.oldbookstore.model.ModelChatPeople
import com.squareup.picasso.Picasso

class ChatPeopleAdapter(private val listdata: ArrayList<ModelChatPeople>, private val activity: Activity) : RecyclerView.Adapter<ChatPeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_chats, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListData = listdata[position]
        holder.textView.text = myListData.name
        val imgUrl = myListData.imageUri
        if (imgUrl != null && imgUrl.isNotEmpty()) {
            Picasso.get().load(imgUrl).fit().into(holder.imageView)
        }
        holder.relativeLayout.setOnClickListener {
            Toast.makeText(it.context, "click on item: ${myListData.name}", Toast.LENGTH_LONG).show()
            val intent = Intent(activity, ChatActivity::class.java)
            intent.putExtra("id", myListData.id)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView_chatpeople)
        val textView: TextView = itemView.findViewById(R.id.textView_chatpeople)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.relativeLayout_chatpeople)
    }
}