package com.example.rick_and_morty_character_guide.ui.main

import androidx.paging.PagingData
import com.example.rick_and_morty_character_guide.models.Character
import kotlinx.coroutines.flow.Flow

sealed interface MainUIState {
    data class Success(val characters: Flow<PagingData<Character>>) : MainUIState
    object Error : MainUIState
    object Loading : MainUIState
}