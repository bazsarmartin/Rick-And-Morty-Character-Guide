package com.example.rick_and_morty_character_guide.ui.main

import com.example.rick_and_morty_character_guide.network.CharacterInterface
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import javax.inject.Inject

class MainRepository @Inject constructor(private val characterDao: CharacterDao, private val characterInterface: CharacterInterface) {
}