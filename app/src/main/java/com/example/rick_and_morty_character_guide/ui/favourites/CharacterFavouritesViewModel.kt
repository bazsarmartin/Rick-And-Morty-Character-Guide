package com.example.rick_and_morty_character_guide.ui.favourites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty_character_guide.models.CharacterEntity
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class CharacterFavouritesViewModel @Inject constructor(private val favouritesRepository: FavouritesRepository): ViewModel() {
    var uiState: FavouritesUIState by mutableStateOf(FavouritesUIState.Loading)
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            uiState = try {
                val characters = favouritesRepository.getCharacters()
                FavouritesUIState.Success(characters)
            } catch (e: IOException) {
                FavouritesUIState.Error
            } catch (e: HttpException) {
                FavouritesUIState.Error
            }
        }
    }

    fun deleteFromFavourites(characterEntity: CharacterEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            favouritesRepository.deleteFromDatabase(characterEntity)
        }
    }
}