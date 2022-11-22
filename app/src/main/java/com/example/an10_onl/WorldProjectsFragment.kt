package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class WorldProjectsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_worldprojects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.skip2).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MakeMoneyActivity())
                .commit()
        }
    }
//        val skip2 = findViewById<TextView>(R.id.skip2)
//        skip2.setOnClickListener() {
//            val intent = Intent(this, MakeMoneyActivity::class.java)
//            startActivity(intent)
//        }
//        Handler().postDelayed({
//            val intent = Intent(this, ThirdPage::class.java)
//            startActivity(intent)
//        }, 2000)

}