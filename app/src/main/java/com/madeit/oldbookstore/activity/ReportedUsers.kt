package com.madeit.oldbookstore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.adapter.UsersAdapter
import com.madeit.oldbookstore.model.ModelUsersData

class ReportedUsers : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var usersAdapter: UsersAdapter? = null
    private val modelUsersDataArrayList: ArrayList<ModelUsersData> = ArrayList()
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reported_users)

        recyclerView = findViewById(R.id.recycler_blocked_users)
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Reports")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                modelUsersDataArrayList.clear()
                for (dataSnapshot in snapshot.children) {
                    val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                    if (modelUsersData != null) {
                        modelUsersDataArrayList.add(modelUsersData)
                    }
                }
                usersAdapter = UsersAdapter(modelUsersDataArrayList, this@ReportedUsers)
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                recyclerView.adapter = usersAdapter
                usersAdapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle possible errors.
            }
        })
    }
}