package com.example.firebasetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list,container,false)
        var recyclerView =view.findViewById<RecyclerView>(R.id.listRecyclerView)
        val questions = ArrayList<Question>()



        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference.child("Questions").child("Group").child(roomNumberString)
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                questions.clear()
                for (ds in dataSnapshot.children) {
                    val QuestionText = ds.value.toString()

                    questions.add(Question(QuestionText))
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
        val listAdapter = QuestionAdapter(questions);
        recyclerView.adapter = listAdapter
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        return view
    }


}


