package com.example.rick_and_morty_character_guide.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty_character_guide.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository): ViewModel() {
    var uiState: DetailsUIState by mutableStateOf(DetailsUIState.Loading)
        private set

    fun getCharacter(id:Int) {
        viewModelScope.launch {
            uiState = try {
                val character = detailsRepository.getCharacter(id)
                DetailsUIState.Success(character)
            } catch (e: IOException) {
                DetailsUIState.Error
            } catch (e: HttpException) {
                DetailsUIState.Error
            }
        }
    }

    fun addToFavourites(character: Character) {
        viewModelScope.launch {
            detailsRepository.addToDatabase(character)
        }
    }
}
