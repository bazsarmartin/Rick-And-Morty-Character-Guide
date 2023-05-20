package com.example.rick_and_morty_character_guide.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
                    ListCharacters()
                }
            }
        }
    }
}

@Composable
fun ListCharacters(characterListViewModel: CharacterListViewModel= hiltViewModel()) {
//    val characterList = characterListViewModel.getCharacters()
//    LazyColumn {
//        items(characterList) { character ->
//            Text(text = character.name)
//        }
//    }
}

@Composable
fun Greeting(name: String, characterListViewModel: CharacterListViewModel= hiltViewModel(), modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyCharacterGuideTheme {
        Greeting("Android")
    }
}
