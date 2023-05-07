package com.example.rick_and_morty_character_guide.network

import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.models.CharacterElement
import com.example.rick_and_morty_character_guide.models.CharacterResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterInterface {
    @GET("character")
    suspend fun getAllCharactersData(@Query("page") page:Int=1): CharacterResult

    @GET("character/{id}")
    suspend fun getSingleCharacterData(@Path("id")id:Int): Character

    @POST("character")
    suspend fun addCharacter(@Body newCharacter: CharacterElement): Int

    @PUT("character/{id}")
    suspend fun updateCharacter(@Path("id") id:Int, @Body newCharacter: CharacterElement): Int

    @DELETE("character/{id}")
    suspend fun deleteCharacter(@Path("id") id:Int)
}