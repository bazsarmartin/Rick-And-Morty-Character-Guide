package com.example.rick_and_morty_character_guide.models

data class Character(val id: Int, val name: String) {
    override fun toString(): String {
        return name
    }
}
