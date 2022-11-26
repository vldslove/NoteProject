package com.example.an10_onl

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class NoteListAdapter(
    private val onClick: callback, val handleDelete: callback
) : RecyclerView.Adapter<NoteListViewHolder>() {

    private var list = arrayListOf<NoteList>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
        return NoteListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false), handleDelete, showNoteInfo = onClick
        )
    }

    override fun onBindViewHolder(holder: NoteListViewHolder, position: Int) {
        holder.showNotes(list[position])
        holder.itemView.setOnClickListener{
            onClick(list[position])
        }
    }

    override fun getItemCount() = list.size

    fun setList(list: ArrayList<NoteList>) {
        this.list = list
        notifyDataSetChanged()
    }
}

