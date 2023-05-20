package com.example.rick_and_morty_character_guide.ui.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rick_and_morty_character_guide.models.CharacterEntity
import com.example.rick_and_morty_character_guide.ui.main.ErrorScreen
import com.example.rick_and_morty_character_guide.ui.main.LoadingScreen

@Composable
fun ListFavourites(modifier: Modifier = Modifier, characterFavouritesViewModel: CharacterFavouritesViewModel = hiltViewModel(), navController: NavController) {
    when (characterFavouritesViewModel.uiState) {
        is FavouritesUIState.Loading -> LoadingScreen(modifier)
        is FavouritesUIState.Success ->
            SuccessFavourites(modifier, (characterFavouritesViewModel.uiState as FavouritesUIState.Success).characters, navController, characterFavouritesViewModel)
        is FavouritesUIState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun SuccessFavourites(modifier: Modifier = Modifier, characterList: List<CharacterEntity>, navController: NavController, characterFavouritesViewModel: CharacterFavouritesViewModel) {
    Column() {
        Button(onClick = { navController.navigate("mainlist") }) {
            Text(text = "Main page")
        }
        LazyColumn{
            items(characterList.size) {
                    characterIndex -> Row(modifier.clickable {
                navController.navigate("details/${characterList[characterIndex].id}")
            }) {
                AsyncImage(
                    model = characterList[characterIndex].image,
                    contentDescription = characterList[characterIndex].name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = characterList[characterIndex].name,
                    modifier = modifier
                )
                Button(onClick = { characterFavouritesViewModel.deleteFromFavourites(characterList[characterIndex])
                    navController.navigate("favouriteslist")}) {
                    Text(text = "Delete")
                }
            }

            }
        }
    }
}