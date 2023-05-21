package com.example.rick_and_morty_character_guide.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column() {
        Row() {
            Button(onClick = { navController.navigate("mainlist") },
                Modifier.padding(35.dp)) {
                Text(text = "Back")
            }
            Button(onClick = { characterDetailsViewModel.addToFavourites(character) },
                Modifier.padding(35.dp)) {
                Text(text = "Add to favourites")
            }
        }
        Row {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Text(
                text = character.name,
                modifier = Modifier
                    .padding(40.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
        Column() {
            Text(
                text = "Status: " + character.status,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Species: " + character.species,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Type: " + character.type,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Gender: " + character.gender,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Origin: " + character.origin.name,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Location: " + character.location.name,
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp
            )
        }
    }


}