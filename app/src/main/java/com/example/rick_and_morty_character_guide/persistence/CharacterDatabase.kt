package com.example.rick_and_morty_character_guide.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rick_and_morty_character_guide.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}