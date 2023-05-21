package com.example.rick_and_morty_character_guide.ui.favourites

import androidx.annotation.WorkerThread
import com.example.rick_and_morty_character_guide.models.CharacterEntity
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import javax.inject.Inject

class FavouritesRepository@Inject constructor(private val characterDao: CharacterDao) {
    suspend fun getCharacters(): List<CharacterEntity> = characterDao.getAllCharacters()

    suspend fun deleteFromDatabase(characterEntity: CharacterEntity) = characterDao.deleteCharacter(characterEntity)
}