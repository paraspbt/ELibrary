package com.example.elibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.elibrary.navigation.AppNavigation
import com.example.elibrary.ui.theme.ELibraryTheme
import com.google.firebase.firestore.FirebaseFirestore
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELibraryTheme {
                // A surface container using the 'background' color from the theme
                val db = FirebaseFirestore.getInstance()
                App()
            }
        }
    }
}

@Composable
fun App() {

    Surface(color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(), content = {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                AppNavigation()

            }
        })

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ELibraryTheme {

    }
}