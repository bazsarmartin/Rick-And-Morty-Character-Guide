package com.example.rick_and_morty_character_guide.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rick_and_morty_character_guide.R
import com.example.rick_and_morty_character_guide.fragments.CharacterListFragment

class CharacterListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterListFragment.newInstance())
                .commitNow()
        }
    }
}