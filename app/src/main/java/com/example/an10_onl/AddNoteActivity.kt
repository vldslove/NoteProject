package com.example.an10_onl

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    private fun validate(): Boolean {
        val isTitleValid = validateTitle()
        val isMessageValid = validateMessage()


        return isTitleValid == null && isMessageValid == null
    }

    private fun validateTitle(): String? {
        val titleInputLayout = findViewById<TextInputLayout>(R.id.title)
        titleInputLayout.editText?.let {
            val result = validateTitle(it.text.toString())
            return when (result) {
                is Invalid -> {
                    titleInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    titleInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }
    private fun validateMessage(): String? {
        val messageInputLayout = findViewById<TextInputLayout>(R.id.message)
        messageInputLayout.editText?.let {
            val result = validateMessage(it.text.toString())
            return when (result) {
                is Invalid -> {
                    messageInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    messageInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        findViewById<TextView>(R.id.back_to_note_list).setOnClickListener() {
            startActivity(Intent(this, ListActivity::class.java))
        }

        val date = LocalDate.now()

        findViewById<Button>(R.id.add_note).setOnClickListener() {
            if (validate()) {

                NoteData.listNote.add(
                    NoteList(
                        findViewById<EditText>(R.id.titleField).text.toString(),
                        findViewById<EditText>(R.id.messageField).text.toString(),
                        date.toString()
                    )
                )
                startActivity(Intent(this, ListActivity::class.java))
            }
        }

    }

}