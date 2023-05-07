package com.example.rick_and_morty_character_guide.ui.details

import com.example.rick_and_morty_character_guide.network.CharacterInterface
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val characterInterface: CharacterInterface) {
}