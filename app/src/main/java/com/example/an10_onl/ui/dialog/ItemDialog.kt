package com.example.an10_onl.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.an10_onl.databinding.DialogItemBinding
import com.example.an10_onl.repositories.NoteRepository

class ItemDialog : DialogFragment() {
    private lateinit var binding: DialogItemBinding
    private val repository = NoteRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogItemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply.setOnClickListener {
            repository.deleteList()
            dismiss()
        }
        binding.cancel.setOnClickListener{
            dismiss()
        }
    }


}