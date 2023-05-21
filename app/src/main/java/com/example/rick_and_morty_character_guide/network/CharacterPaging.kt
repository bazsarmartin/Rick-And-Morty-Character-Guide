package com.example.rick_and_morty_character_guide.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rick_and_morty_character_guide.ui.main.CharacterListRepository
import retrofit2.HttpException
import java.io.IOException
import com.example.rick_and_morty_character_guide.models.Character

class CharacterPaging(private val mainRepository: CharacterListRepository) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int?
    {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextPage = params.key ?: 1
            val characters = mainRepository.getCharacters(nextPage)
            LoadResult.Page(
                data = characters,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (characters.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}