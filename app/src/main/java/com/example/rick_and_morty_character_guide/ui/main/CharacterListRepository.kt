package com.example.rick_and_morty_character_guide.ui.main

import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.network.CharacterInterface
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import javax.inject.Inject

class CharacterListRepository @Inject constructor(private val characterInterface: CharacterInterface) {
    suspend fun getCharacters():List<Character> {
        var characters=characterInterface.getAllCharactersData()
        return characters.results
    }
}