package com.example.rick_and_morty_character_guide.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rick_and_morty_character_guide.R
import com.example.rick_and_morty_character_guide.ui.main.CharacterListFragment
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {
    @Inject
    lateinit var characterDao: CharacterDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_list_activity)

        characterDao.getAllCharacters()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterListFragment.newInstance())
                .commitNow()
        }
    }
}