package com.example.rick_and_morty_character_guide.network

import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.models.CharacterResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterInterface {
    @GET("/character")
    suspend fun getAllCharactersData(@Query("page") page:Int=1):CharacterResult

    @GET("/character/{id}")
    suspend fun getSingleCharacterData(@Path("id")id:Int):Character
}