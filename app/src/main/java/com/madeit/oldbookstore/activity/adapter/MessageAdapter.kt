package com.madeit.oldbookstore.activity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.model.ModelMessage

class MessageAdapter(
    private val messages: List<ModelMessage>
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    // Function to bind the view in Card view(here "message.xml") with data in
    // model class(here "ModelMessage")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val model = messages[position]

        if (model.message!!.contains("To:")) {
            holder.messageFrom.visibility = View.GONE
            holder.messageTo.visibility = View.VISIBLE
            val message = model.message!!.split(":")[1]
            holder.messageTo.text = message
        }

        if (model.message!!.contains("From:")) {
            holder.messageTo.visibility = View.GONE
            holder.messageFrom.visibility = View.VISIBLE
            val message = model.message!!.split(":")[1]
            holder.messageFrom.text = message
        }
    }

    // Function to tell the class about the Card view (here "message.xml") in which the data will be shown
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message, parent, false)
        return MessageViewHolder(view)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return messages.size
    }

    // Sub Class to create references of the views in Card view (here "message.xml")
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTo: TextView = itemView.findViewById(R.id.txt_to)
        val messageFrom: TextView = itemView.findViewById(R.id.txt_from)
    }
}