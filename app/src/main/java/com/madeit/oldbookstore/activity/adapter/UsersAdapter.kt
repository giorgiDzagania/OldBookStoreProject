package com.madeit.oldbookstore.activity.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.ViewProfileActivity
import com.madeit.oldbookstore.model.ModelUsersData
import com.squareup.picasso.Picasso
import java.util.UUID

class UsersAdapter(
    private val listdata: ArrayList<ModelUsersData>,
    private val activity: Activity
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private val databaseReference: DatabaseReference = FirebaseDatabase
        .getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
        .getReference().child("Blocked")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.users_list, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListData = listdata[position]
        holder.name.text = myListData.name
        holder.city.text = myListData.city
        holder.email.text = myListData.email
        holder.phoneNumber.text = myListData.phoneNumber
        holder.points.text = myListData.point
        val imgUrl = myListData.imageUri
        if (!imgUrl.isNullOrEmpty()) {
            Picasso.get().load(imgUrl).fit().into(holder.imageView)
        }
        holder.relativeLayout.setOnClickListener {
            Toast.makeText(it.context, "click on item: ${myListData.name}", Toast.LENGTH_LONG).show()
            val layoutInflater = LayoutInflater.from(activity)
            val promptView = layoutInflater.inflate(R.layout.prompt, null)

            val alertD = AlertDialog.Builder(activity).create()

            val block = promptView.findViewById<Button>(R.id.block)
            val cancel = promptView.findViewById<Button>(R.id.cancel)
            val viewProfile = promptView.findViewById<Button>(R.id.view)

            block.setOnClickListener {
                val modelUsersData = ModelUsersData(
                    myListData.phoneNumber, myListData.name, myListData.email,
                    myListData.city, myListData.point, myListData.userID, myListData.imageUri
                )
                databaseReference.child(UUID.randomUUID().toString()).setValue(modelUsersData)
                Toast.makeText(activity.applicationContext, "User Blocked", Toast.LENGTH_SHORT).show()
                alertD.dismiss()
            }

            cancel.setOnClickListener {
                alertD.dismiss()
            }

            viewProfile.setOnClickListener {
                val intent = Intent(activity, ViewProfileActivity::class.java).apply {
                    putExtra("name", myListData.name)
                    putExtra("phoneNumber", myListData.phoneNumber)
                    putExtra("location", myListData.city)
                    putExtra("image", myListData.imageUri)
                    putExtra("email", myListData.email)
                }
                alertD.dismiss()
                activity.startActivity(intent)
            }

            alertD.setView(promptView)
            alertD.show()
        }
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView_usersList)
        val name: TextView = itemView.findViewById(R.id.name_usersList)
        val email: TextView = itemView.findViewById(R.id.email_usersList)
        val phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber_usersList)
        val city: TextView = itemView.findViewById(R.id.city_usersList)
        val points: TextView = itemView.findViewById(R.id.points_usersList)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.relativeLayout_userList)
    }
}