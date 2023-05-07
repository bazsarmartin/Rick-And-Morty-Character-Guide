package com.example.rick_and_morty_character_guide.di

import android.content.Context
import androidx.room.Room
import com.example.rick_and_morty_character_guide.persistence.CharacterDao
import com.example.rick_and_morty_character_guide.persistence.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Singleton
    @Provides
    fun provideCharacterDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        CharacterDatabase::class.java,
        "characters"
    ).build()

    @Provides
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
        return characterDatabase.characterDao()
    }
}