package com.example.firebasetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuestionAdapter(val userlist:ArrayList<Question>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.question_list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userlist.size
           }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question: Question = userlist[position]
        holder.textViewQuestion.text = question.question
        }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewQuestion = itemView.findViewById<TextView>(R.id.textViewQuestion)
    }
}