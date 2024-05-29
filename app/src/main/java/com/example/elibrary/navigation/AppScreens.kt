package com.example.elibrary.navigation

enum class AppScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    AppHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;

//    companion object {
//        fun fromRoute(route: String?): AppScreens
//                = when(route?.substringBefore("/")) {
//            SplashScreen.name -> SplashScreen
//            LoginScreen.name -> LoginScreen
//            CreateAccountScreen.name -> CreateAccountScreen
//            AppHomeScreen.name -> AppHomeScreen
//            SearchScreen.name -> SearchScreen
//            DetailScreen.name -> DetailScreen
//            UpdateScreen.name -> UpdateScreen
//            ReaderStatsScreen.name -> ReaderStatsScreen
//            null -> AppHomeScreen
//            else -> throw IllegalArgumentException("Route $route is not recognized")
//        }
//    }
}