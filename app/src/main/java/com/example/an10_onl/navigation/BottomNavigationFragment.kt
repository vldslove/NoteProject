package com.example.an10_onl.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.an10_onl.R
import com.example.an10_onl.ui.addNote.AddNoteFragment
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.ui.profile.ProfileFragment
import com.example.an10_onl.ui.search.SearchFragment
import com.example.an10_onl.databinding.FragmentBottomnavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class BottomNavigationFragment : Fragment() {
    private lateinit var binding: FragmentBottomnavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomnavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment())
                    .addToBackStack("")
                    .commit()
                    true
                }
                R.id.search -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.addNote -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, AddNoteFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                R.id.profile -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .addToBackStack("")
                        .commit()
                    true
                }
                else -> {
                    false
                }

            }
        }
    }
}