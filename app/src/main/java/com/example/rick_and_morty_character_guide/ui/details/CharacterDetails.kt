package com.example.rick_and_morty_character_guide.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.rick_and_morty_character_guide.R
import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.ui.main.CharacterListViewModel
import com.example.rick_and_morty_character_guide.ui.main.ErrorScreen
import com.example.rick_and_morty_character_guide.ui.main.LoadingScreen
import com.example.rick_and_morty_character_guide.ui.main.MainUIState
import com.example.rick_and_morty_character_guide.ui.main.SuccessScreen

@Composable
fun ShowCharacterDetails(modifier: Modifier = Modifier, characterDetailsViewModel: CharacterDetailsViewModel = hiltViewModel(), navController: NavController, id: Int) {
    characterDetailsViewModel.getCharacter(id)
    when (characterDetailsViewModel.uiState) {
        is DetailsUIState.Loading -> LoadingScreen(modifier)
        is DetailsUIState.Success ->
            ShowSuccess(modifier, (characterDetailsViewModel.uiState as DetailsUIState.Success).character, navController, characterDetailsViewModel)
        is DetailsUIState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun ShowSuccess(modifier: Modifier = Modifier, character: Character, navController: NavController, characterDetailsViewModel: CharacterDetailsViewModel) {
    Row {
        Text(
            text = character.name,
            modifier = modifier
        )
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp).clip(CircleShape)
        )
        Button(onClick = { navController.navigate("mainlist") }) {
            Text(text = "Back")
        }
        Button(onClick = { characterDetailsViewModel.addToFavourites(character) }) {
            Text(text = "Add to favourites")
        }
    }

}