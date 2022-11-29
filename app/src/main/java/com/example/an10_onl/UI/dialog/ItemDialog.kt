package com.example.an10_onl.UI.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.an10_onl.db.NoteData
import com.example.an10_onl.databinding.DialogItemBinding

class ItemDialog : DialogFragment() {
    private lateinit var binding: DialogItemBinding
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
            NoteData.listNote.clear()
            dismiss()
        }
        binding.cancel.setOnClickListener{
            dismiss()
        }
    }


}