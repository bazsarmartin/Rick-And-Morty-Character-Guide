package com.example.rick_and_morty_character_guide.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty_character_guide.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val characterListRepository: CharacterListRepository) : ViewModel() {
//    init {
//        viewModelScope.launch {
//            characterListRepository.getCharacters()
//        }
//    }

    suspend fun getCharacters(): List<Character> = characterListRepository.getCharacters()
}