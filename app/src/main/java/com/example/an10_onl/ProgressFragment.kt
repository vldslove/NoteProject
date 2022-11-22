package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProgressFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.skip6).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .commit()
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_progress)
//        val skip = findViewById<TextView>(R.id.skip6)
//        skip.setOnClickListener(){
//            val intent = Intent(this, SignupFragment::class.java)
//            startActivity(intent)
//        }
////        Handler().postDelayed({
////            val intent = Intent(this, SignupFragment::class.java)
////            startActivity(intent)
////            finish()
////        }, 2000)
    }
}
