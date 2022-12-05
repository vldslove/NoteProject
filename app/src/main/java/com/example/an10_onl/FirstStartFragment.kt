package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstStartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_firststart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.discover_the_platform).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, WorldProjectsFragment())
                .commit()
        }
        view.findViewById<TextView>(R.id.login).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
    }



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_firststart)
//        val button = findViewById<Button>(R.id.discover_the_platform)
//        button.setOnClickListener() {
//            val intent = Intent(this, WorldProjectsFragment::class.java)
//            startActivity(intent)
//        }
//        val login = findViewById<TextView>(R.id.login)
//        login.setOnClickListener() {
//            val intent = Intent(this, LoginFragment::class.java)
//            startActivity(intent)
//
//        }
//
//    }
}