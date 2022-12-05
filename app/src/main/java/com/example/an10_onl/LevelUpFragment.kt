package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class LevelUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_levelup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.skip5).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ProgressFragment())
                .commit()
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_levelup)
//        val skip2 = findViewById<TextView>(R.id.skip5)
//        skip2.setOnClickListener() {
//            val intent = Intent(this, ProgressFragment::class.java)
//            startActivity(intent)
//        }
////        Handler().postDelayed({
////            val intent = Intent(this, SixthPage::class.java)
////            startActivity(intent)
////            finish()
////        }, 2000)
//    }
}