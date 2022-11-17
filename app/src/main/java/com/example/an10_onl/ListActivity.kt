package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        findViewById<TextView>(R.id.logout).setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
        findViewById<TextView>(R.id.add_new_note).setOnClickListener(){
            startActivity(Intent(this, AddNoteActivity::class.java))
        }


        findViewById<RecyclerView>(R.id.recyclerView).run {
                adapter = NoteListAdapter()
                layoutManager = LinearLayoutManager(this@ListActivity)
            (adapter as? NoteListAdapter)?.setList(NoteData.listNote)
        }
    }
}