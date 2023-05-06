package com.example.rick_and_morty_character_guide.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rick_and_morty_character_guide.R
import com.example.rick_and_morty_character_guide.fragments.CharacterListFragment
import com.example.rick_and_morty_character_guide.models.CharacterResult
import com.example.rick_and_morty_character_guide.network.CharacterService
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity() {
//    @Inject
//    lateinit var characterResult: CharacterResult
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterListFragment.newInstance())
                .commitNow()
        }
//        val results = characterResult.results
//        val a = 1
    }
}