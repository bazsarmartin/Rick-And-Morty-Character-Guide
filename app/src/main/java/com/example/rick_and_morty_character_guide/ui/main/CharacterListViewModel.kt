package com.example.rick_and_morty_character_guide.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rick_and_morty_character_guide.network.CharacterPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val characterListRepository: CharacterListRepository) : ViewModel() {
    var uiState: MainUIState by mutableStateOf(MainUIState.Loading)
        private set

    init {
        viewModelScope.launch {
            uiState = try {
                val characters = Pager(PagingConfig(pageSize = 10))
                {
                    CharacterPaging(characterListRepository)
                }.flow.cachedIn(viewModelScope)
                MainUIState.Success(characters)
            } catch (e: IOException) {
                MainUIState.Error
            } catch (e: HttpException) {
                MainUIState.Error
            }
        }
    }

}