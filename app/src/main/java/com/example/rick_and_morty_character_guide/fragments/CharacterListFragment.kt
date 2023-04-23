package com.example.rick_and_morty_character_guide.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rick_and_morty_character_guide.R
import com.example.rick_and_morty_character_guide.viewmodels.CharacterListViewModel

class CharacterListFragment : Fragment() {
    companion object {
        fun newInstance() = CharacterListFragment()
    }

    private lateinit var viewModel: CharacterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.character_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this)[CharacterListViewModel::class.java]
    }
}