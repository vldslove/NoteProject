package com.example.an10_onl

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun showNotes(note: NoteList) {
        view.apply {
            findViewById<TextView>(R.id.title).text = note.title
            findViewById<TextView>(R.id.message).text = note.message
            findViewById<TextView>(R.id.date).text = note.date
            findViewById<Button>(R.id.shareButton).setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,  note.message)
                val chosenIntent = Intent.createChooser(intent, "qwe")
                context.startActivity(chosenIntent)
            }
        }

    }

}

