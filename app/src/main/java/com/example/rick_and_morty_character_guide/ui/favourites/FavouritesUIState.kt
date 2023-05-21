package com.example.rick_and_morty_character_guide.ui.favourites

import com.example.rick_and_morty_character_guide.models.CharacterEntity

sealed interface FavouritesUIState {
    data class Success(val characters: List<CharacterEntity>) : FavouritesUIState
    object Error : FavouritesUIState
    object Loading : FavouritesUIState
}