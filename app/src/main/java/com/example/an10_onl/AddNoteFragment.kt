package com.example.an10_onl

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate

class AddNoteFragment : Fragment() {
    private var titleInputLayout: TextInputLayout? = null
    private var messageInputLayout: TextInputLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_addnote, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titleInputLayout = view.findViewById(R.id.title)
        messageInputLayout = view.findViewById(R.id.message)
        val date = LocalDate.now()

        view.findViewById<TextView>(R.id.back_to_note_list).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, com.example.an10_onl.ListFragment())
                .commit()
        }
        view.findViewById<Button>(R.id.add_note).setOnClickListener {
            if (validate()) {
                NoteData.listNote.add(
                    NoteList(
                        view.findViewById<EditText>(R.id.titleField).text.toString(),
                        view.findViewById<EditText>(R.id.messageField).text.toString(),
                        date.toString()
                    )
                )
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, com.example.an10_onl.ListFragment())
                    .commit()
            }
        }
    }

    private fun validate(): Boolean {
        val isTitleValid = validateTitle()
        val isMessageValid = validateMessage()


        return isTitleValid == null && isMessageValid == null
    }

    private fun validateTitle(): String? {
        titleInputLayout?.editText?.let {
            val result = validateTitle(it.text.toString())
            return when (result) {
                is Invalid -> {
                    titleInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    titleInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateMessage(): String? {
        messageInputLayout?.editText?.let {
            val result = validateMessage(it.text.toString())
            return when (result) {
                is Invalid -> {
                    messageInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    messageInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }


}