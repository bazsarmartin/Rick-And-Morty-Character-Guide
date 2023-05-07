package com.example.rick_and_morty_character_guide.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rick_and_morty_character_guide.models.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<CharacterEntity>>

    @Insert
    suspend fun insertCharacter(character: CharacterEntity) : Long

    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)
}