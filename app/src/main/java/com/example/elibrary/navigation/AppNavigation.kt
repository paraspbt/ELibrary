package com.example.elibrary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elibrary.screens.AppSplashScreen
import com.example.elibrary.screens.login.AppLoginScreen


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


    }
}