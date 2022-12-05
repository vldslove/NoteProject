package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChatAndDevelopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chatanddevelop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.skip4).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LevelUpFragment())
                .commit()
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_chatanddevelop)
//        val skip2 = findViewById<TextView>(R.id.skip4)
//        skip2.setOnClickListener() {
//            val intent = Intent(this, LevelUpFragment::class.java)
//            startActivity(intent)
//        }
////        Handler().postDelayed({
////            val intent = Intent(this, FifthPage::class.java)
////            startActivity(intent)
////            finish()
////        }, 2000)
//    }
}