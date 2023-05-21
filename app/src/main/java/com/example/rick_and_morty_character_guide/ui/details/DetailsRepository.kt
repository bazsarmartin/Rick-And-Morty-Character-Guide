package com.example.rick_and_morty_character_guide.ui.details

import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.models.CharacterEntity
import com.example.rick_and_morty_character_guide.network.CharacterInterface
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val characterInterface: CharacterInterface, private val characterDao: CharacterDao) {
    suspend fun getCharacter(id: Int): Character = characterInterface.getSingleCharacterData(id)

    suspend fun addToDatabase(character: Character) {
        val entity = CharacterEntity(
            character.id,
            character.name,
            character.status,
            character.species,
            character.type,
            character.gender,
            character.origin.name,
            character.location.name,
            character.image,
            character.episode.joinToString())
        characterDao.insertCharacter(entity)
    }
}