package com.example.rick_and_morty_character_guide.ui.favourites

import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import javax.inject.Inject

class FavouritesRepository@Inject constructor(private val characterDao: CharacterDao) {
}