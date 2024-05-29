package com.example.elibrary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elibrary.screens.AppSplashScreen
import com.example.elibrary.screens.home.AppHomeScreen
import com.example.elibrary.screens.login.AppLoginScreen
import com.example.elibrary.screens.search.BookSearch



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.SplashScreen.name ) {

        composable(AppScreens.SplashScreen.name) {
            AppSplashScreen(navController = navController)
        }
        composable(AppScreens.LoginScreen.name) {
            AppLoginScreen(navController = navController)
        }
        composable(AppScreens.AppHomeScreen.name) {
            AppHomeScreen(navController = navController)
        }
        composable(AppScreens.SearchScreen.name) {
            BookSearch(navController = navController)
        }

    }
}