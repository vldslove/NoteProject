package com.example.an10_onl.UI.listNote

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.an10_onl.model.NoteList
import com.example.an10_onl.R
import com.example.an10_onl.UI.addNote.AddNoteFragment
import com.example.an10_onl.UI.dialog.ItemBottomDialog
import com.example.an10_onl.UI.login.LoginFragment
import com.example.an10_onl.databinding.FragmentListBinding
import com.example.an10_onl.UI.listNote.noteadapter.NoteListAdapter
import com.example.an10_onl.db.NoteData
import com.example.an10_onl.repositories.NoteRepository


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        binding.addNewNote.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment())
                .commit()
        }
        binding.recyclerView.run {
            adapter = NoteListAdapter(
                onClick = {
                    ItemBottomDialog().getNoteFragmentInstance(it.title, it.message)
                        .show(childFragmentManager, "")
                },
                handleDelete = {
                    viewModel.deleteNote(it.title,it.message,it.date)
                    adapter?.notifyDataSetChanged()
                },
                shareNote = {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, it.title)
                    intent.putExtra(Intent.EXTRA_TEXT, it.message)
                    val chosenIntent = Intent.createChooser(intent, "qwe")
                    context.startActivity(chosenIntent)
                }
            )
            layoutManager = LinearLayoutManager(requireContext())

        }
        viewModel.listNote.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as? NoteListAdapter)?.setList(it)
        }
        viewModel.getList()

    }


}






