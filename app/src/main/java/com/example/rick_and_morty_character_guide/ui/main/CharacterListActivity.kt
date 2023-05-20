package com.example.rick_and_morty_character_guide.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.rick_and_morty_character_guide.models.Character
import com.example.rick_and_morty_character_guide.ui.navigation.CharacterNavHost
import com.example.rick_and_morty_character_guide.ui.theme.RickAndMortyCharacterGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyCharacterGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CharacterNavHost()
                }
            }
        }
    }
}

@Composable
fun ListCharacters(modifier: Modifier = Modifier, characterListViewModel: CharacterListViewModel= hiltViewModel(), navController: NavController) {
    when (characterListViewModel.uiState) {
        is MainUIState.Loading -> LoadingScreen(modifier)
        is MainUIState.Success ->
            SuccessScreen(modifier, (characterListViewModel.uiState as MainUIState.Success).characters.collectAsLazyPagingItems(), navController)
        is MainUIState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun SuccessScreen(modifier: Modifier = Modifier, characterList: LazyPagingItems<Character>, navController: NavController) {
    Column() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "List of characters",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Button(onClick = { navController.navigate("favouriteslist") },
                Modifier.padding(20.dp)) {
                Text(text = "Favourites")
            }
        }
        LazyColumn{
            items(characterList.itemCount) {
                    characterIndex -> characterList.getAsState(index = characterIndex).value?.let {
                Row(modifier.clickable {
                    navController.navigate("details/${it.id}")
                }) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .padding(30.dp)
                    )
                }
            }

            }
        }
    }

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.size(200.dp),
            text = "Loading..."
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text("Error...")
    }
}
