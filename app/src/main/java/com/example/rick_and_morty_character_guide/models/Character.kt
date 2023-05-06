package com.example.rick_and_morty_character_guide.models

data class Character(val id: Int,
                     val name: String,
                     val status: String,
                     val species: String,
                     val type: String,
                     val gender: String,
                     val origin: Location,
                     val location: Location,
                     val image: String,
                     val episode: List<String>)

data class Location(val name: String)

data class Info(val count: Int, val pages: Int, val next: String, val prev: String)

data class CharacterResult(val info: Info, val results: List<Character>)
