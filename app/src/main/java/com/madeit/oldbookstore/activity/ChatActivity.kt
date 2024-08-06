package com.madeit.oldbookstore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.R
import com.madeit.oldbookstore.activity.adapter.MessageAdapter
import com.madeit.oldbookstore.model.ModelMessage
import com.madeit.oldbookstore.model.ModelUsersData
import java.sql.Timestamp
import java.util.UUID

class ChatActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter
    private lateinit var mbase: DatabaseReference
    private lateinit var databaseReference: DatabaseReference
    private lateinit var message: EditText
    private lateinit var sendMessage: ImageView
    private lateinit var modelUsersData: ModelUsersData
    private val messages: MutableList<ModelMessage> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val id = intent.getStringExtra("id")

        databaseReference = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Users")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)!!
                    if (modelUsersData.userID == id) {
                        break
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("ChatActivity", "loadPost:onCancelled", error.toException())
            }
        })

        mbase = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Messages")

        recyclerView = findViewById(R.id.recycler_chat)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        adapter = MessageAdapter(messages)
        recyclerView.adapter = adapter

        message = findViewById(R.id.message_chat)
        sendMessage = findViewById(R.id.send_message_chat)

        sendMessage.setOnClickListener {
            if (mbase == null) {
                addToMessages(id!!, message.text.toString())
                message.setText("")
            } else {
                mbase.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (dataSnapshot in snapshot.children) {
                            if (dataSnapshot.key == "${FirebaseAuth.getInstance().currentUser!!.uid}_$id") {
                                addToMessages(id!!, message.text.toString())
                                message.setText("")
                                break
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w("ChatActivity", "loadPost:onCancelled", error.toException())
                    }
                })
            }
        }

        fetchMessages(id)
    }

    private fun fetchMessages(id: String?) {
        mbase.child("${FirebaseAuth.getInstance().currentUser!!.uid}_$id").orderByChild("time")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messages.clear()
                    for (dataSnapshot in snapshot.children) {
                        val message = dataSnapshot.getValue(ModelMessage::class.java)
                        message?.let { messages.add(it) }
                    }
                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("ChatActivity", "loadPost:onCancelled", error.toException())
                }
            })
    }

    private fun addToMessages(id: String, message: String) {
        if (!TextUtils.isEmpty(message)) {
            val timestamp = Timestamp(System.currentTimeMillis())
            val modelMessage1 = ModelMessage(id, "To:$message", timestamp.time.toString())
            val modelMessage2 = ModelMessage(FirebaseAuth.getInstance().currentUser!!.uid, "From:$message", timestamp.time.toString())

            mbase.child("${FirebaseAuth.getInstance().currentUser!!.uid}_$id").child(UUID.randomUUID().toString()).setValue(modelMessage1)
            mbase.child("$id${FirebaseAuth.getInstance().currentUser!!.uid}").child(UUID.randomUUID().toString()).setValue(modelMessage2)
        }
    }
}