package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        view.findViewById<TextView>(R.id.logout).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        view.findViewById<TextView>(R.id.add_new_note).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment())
                .commit()
        }
        recyclerView.run {
            adapter = NoteListAdapter(
                onClick = {note ->
                    viewNote(note)
                },
                handleDelete = {note ->
                    deleteNote(note)
                }
            )
            layoutManager = LinearLayoutManager(activity)
            (adapter as? NoteListAdapter)?.setList(NoteData.listNote)

        }

    }
    fun viewNote(note: NoteList){
        ItemBottomDialog().getNoteFragmentInstance(note.title, note.message).show(childFragmentManager, "")
    }

    fun deleteNote(note: NoteList){
        var toDeleteNote: NoteList? = null
        NoteData.listNote.forEach{_note ->
            if (_note.title == note.title){
                toDeleteNote = _note
            }
        }
        if (toDeleteNote != null){
            NoteData.listNote.remove(toDeleteNote)
            val adapter = recyclerView.adapter as NoteListAdapter
            adapter.setList(NoteData.listNote)
        }
    }
}

