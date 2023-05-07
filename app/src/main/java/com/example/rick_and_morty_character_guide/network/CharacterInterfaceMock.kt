package com.example.rick_and_morty_character_guide.network

import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.models.CharacterResult

class CharacterInterfaceMock {
    suspend fun getAllCharactersData(): CharacterResult =TODO()
    suspend fun getSingleCharacterData(): Character= TODO()
    suspend fun addCharacter(): Int= TODO()
    suspend fun updateCharacter(): Int= TODO()
    suspend fun deleteCharacter(): Nothing = TODO()
}