package com.example.elibrary.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AppHomeScreen(navController: NavController){

    NavigationDrawer(navController)
}