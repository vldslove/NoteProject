package com.example.an10_onl

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
typealias callback = (note: NoteList)-> Unit
class NoteListViewHolder(private val view: View, val handleDelete: callback, val showNoteInfo: callback) : RecyclerView.ViewHolder(view) {

    fun showNotes(note: NoteList) {
        view.findViewById<Button>(R.id.deleteButton2).setOnClickListener {
        }
        view.apply {
            findViewById<TextView>(R.id.title).text = note.title
            findViewById<TextView>(R.id.message).text = note.message
            findViewById<TextView>(R.id.date).text = note.date
            findViewById<Button>(R.id.shareButton).setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, note.message)
                val chosenIntent = Intent.createChooser(intent, "qwe")
                context.startActivity(chosenIntent)
            }
            findViewById<Button>(R.id.deleteButton2).setOnClickListener {
                handleDelete(note)
            }
            findViewById<LinearLayout>(R.id.notes_layout).setOnClickListener{
                showNoteInfo(note)

            }

        }

    }


}

