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

class AllUsersActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var usersAdapter: UsersAdapter? = null
    private var modelUsersDataArrayList = ArrayList<ModelUsersData>()
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_users)

        recyclerView = findViewById(R.id.recycler_all_users)
        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference().child("Users")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                modelUsersDataArrayList.clear()
                for (dataSnapshot in snapshot.children) {
                    val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                    if (modelUsersData != null) {
                        modelUsersDataArrayList.add(modelUsersData)
                    }
                }
                usersAdapter = UsersAdapter(modelUsersDataArrayList, this@AllUsersActivity)
                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(this@AllUsersActivity)
                    adapter = usersAdapter
                }
                usersAdapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled
            }
        })
    }
}