package com.example.rick_and_morty_character_guide.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rick_and_morty_character_guide.ui.details.ShowCharacterDetails
import com.example.rick_and_morty_character_guide.ui.favourites.ListFavourites
import com.example.rick_and_morty_character_guide.ui.main.ListCharacters

@Composable
fun CharacterNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mainlist"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("mainlist") { ListCharacters(navController=navController) }
        composable("favouriteslist") { ListFavourites(navController = navController) }
        composable("details/{characterid}",
            arguments = listOf(
                navArgument("characterid"){type = NavType.IntType}
            )
        ) {
            val characterId = it.arguments?.getInt("characterid")
            characterId?.let {
                ShowCharacterDetails(navController = navController, id = characterId)
            }
        }
    }
}