package com.example.rick_and_morty_character_guide.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(@PrimaryKey(autoGenerate = true)val id: Int,
                           val name: String,
                           val status: String,
                           val species: String,
                           val type: String,
                           val gender: String,
                           val origin: String,
                           val location: String,
                           val image: String,
                           val episode: String)
