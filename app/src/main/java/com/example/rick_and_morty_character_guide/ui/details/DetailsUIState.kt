package com.example.rick_and_morty_character_guide.ui.details

import com.example.rick_and_morty_character_guide.models.Character

sealed interface DetailsUIState {
    data class Success(val character: Character) : DetailsUIState
    object Error : DetailsUIState
    object Loading : DetailsUIState
}