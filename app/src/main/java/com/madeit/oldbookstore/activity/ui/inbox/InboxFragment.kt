package com.madeit.oldbookstore.activity.ui.inbox

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madeit.oldbookstore.activity.adapter.ChatPeopleAdapter
import com.madeit.oldbookstore.databinding.FragmentInboxBinding
import com.madeit.oldbookstore.model.ModelChatPeople
import com.madeit.oldbookstore.model.ModelUsersData

class InboxFragment : Fragment() {

    private lateinit var binding: FragmentInboxBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var chatPeopleArrayList: ArrayList<ModelChatPeople>
    private lateinit var chatPeopleAdapter: ChatPeopleAdapter
    private lateinit var modelUsersDataArrayList: ArrayList<ModelUsersData>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInboxBinding.inflate(inflater, container, false)
        val root: View = binding.root

        modelUsersDataArrayList = ArrayList()
        chatPeopleArrayList = ArrayList()
        recyclerView = binding.recyclerInbox

        database = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Users")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                modelUsersDataArrayList.clear()
                for (dataSnapshot in snapshot.children) {
                    val modelUsersData = dataSnapshot.getValue(ModelUsersData::class.java)
                    if (modelUsersData != null) {
                        modelUsersDataArrayList.add(modelUsersData)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("InboxFragment", "Error fetching users data: ${error.message}")
            }
        })

        databaseReference = FirebaseDatabase.getInstance("https://old-book-store-144a2-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("Messages")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                chatPeopleArrayList.clear()
                val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
                for (dataSnapshot in snapshot.children) {
                    val idSplit = dataSnapshot.key?.split("_") ?: listOf("")
                    val id = idSplit[1]
                    val id2 = idSplit[0]
                    for (i in modelUsersDataArrayList.indices) {
                        val user = modelUsersDataArrayList[i]
                        if (id == user.userID && id != currentUserUid && id2 == currentUserUid) {
                            val chatPeople = ModelChatPeople(user.name, user.imageUri, user.userID)
                            chatPeople.name?.let { Log.d("myApp", it) }
                            chatPeopleArrayList.add(chatPeople)
                        }
                    }
                }
                chatPeopleAdapter = activity?.let { ChatPeopleAdapter(chatPeopleArrayList, it) }!!
                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = chatPeopleAdapter
                }
                chatPeopleAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("InboxFragment", "Error fetching messages: ${error.message}")
            }
        })

        return root
    }

    override fun onStart() {
        super.onStart()
        // Add any necessary onStart logic here
    }

    override fun onDestroy() {
        super.onDestroy()
        // Add any necessary onDestroy logic here
    }
}