package com.example.rick_and_morty_character_guide.ui.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Favourite characters",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Button(onClick = { navController.navigate("mainlist") },
                Modifier.padding(20.dp)) {
                Text(text = "Main page")
            }
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
                    modifier = Modifier
                        .padding(30.dp)
                )
                Button(onClick = { characterFavouritesViewModel.deleteFromFavourites(characterList[characterIndex])
                    navController.navigate("favouriteslist")},
                    Modifier.paddingFromBaseline(top = 45.dp)) {
                    Text(text = "Delete")
                }
            }

            }
        }
    }
}