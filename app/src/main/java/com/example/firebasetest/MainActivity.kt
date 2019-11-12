package com.example.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

import android.widget.EditText

import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.dialog_add_question.view.*


class MainActivity : AppCompatActivity() {


    private lateinit var database: DatabaseReference
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment:ListFragment = ListFragment()
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()




    }

    fun onAddCliclked(view: View) {
        showCreateCategoryDialog()

        Toast.makeText(applicationContext,"Add button clicked",Toast.LENGTH_SHORT).show()
    }



    fun onStartCliclked(view: View) {
        Toast.makeText(applicationContext,"Start button clicked",Toast.LENGTH_SHORT).show()
    }

    fun showCreateCategoryDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_question, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Add question")
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.dialogLoginBtn.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            val question = mDialogView.dialogQuestion.text.toString()

            //set the input text in TextView
            database = FirebaseDatabase.getInstance().reference
            database.child("Questions").child("Group").child(roomNumberString).push().setValue(question)
            Toast.makeText(applicationContext,question,Toast.LENGTH_SHORT).show()
        }
        //cancel button click of custom layout
        mDialogView.dialogCancelBtn.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
        }

    }
}

