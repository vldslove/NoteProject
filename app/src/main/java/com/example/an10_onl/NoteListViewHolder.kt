package com.example.an10_onl

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun showNotes(note: NoteList) {
        view.apply {
            findViewById<TextView>(R.id.title).text = note.title
            findViewById<TextView>(R.id.message).text = note.message
            findViewById<TextView>(R.id.date).text = note.date

        }
    }
}