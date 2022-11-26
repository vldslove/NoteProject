package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemBottomDialog : BottomSheetDialogFragment() {
    private val TITLE_EXTRA = "title"
    private val MESSAGE_EXTRA = "message"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.title_show).text = arguments?.getString(TITLE_EXTRA)
        view.findViewById<TextView>(R.id.message_show).text = arguments?.getString(MESSAGE_EXTRA)

    }

        fun getNoteFragmentInstance(title: String, message: String): ItemBottomDialog {
            return ItemBottomDialog().apply {
                arguments = bundleOf(
                    TITLE_EXTRA to title,
                    MESSAGE_EXTRA to message
                )

        }
    }
}