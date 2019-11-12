package com.example.firebasetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ActivityLogin : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        database = FirebaseDatabase.getInstance().reference
        val nameEdit = findViewById<EditText>(R.id.editTextName)

        val roomEdit = findViewById<EditText>(R.id.editTextRoomId)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

            if (nameEdit.text.isNotEmpty() && roomEdit.text.isNotEmpty()) {
                roomNumberString = roomEdit.text.toString()
                database.child("Questions").child("Group").setValue(roomEdit.text.toString())
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext,"Please complete fields",Toast.LENGTH_LONG).show()
            }


        }
    }
}
