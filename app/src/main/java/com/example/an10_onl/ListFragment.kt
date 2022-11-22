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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = NoteListAdapter()
            layoutManager = LinearLayoutManager(activity)
            (adapter as? NoteListAdapter)?.setList(NoteData.listNote)

        }
        view.findViewById<Button>(R.id.deleteButton).setOnClickListener {
            ItemDialog().show(childFragmentManager, "")
        }

    }
}

