package com.example.digikalaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.digikalaapp.ui.screens.basket.BasketScreen
import com.example.digikalaapp.ui.screens.category.CategoryScreen
import com.example.digikalaapp.ui.screens.home.HomeScreen
import com.example.digikalaapp.ui.screens.ProfileScreen
import com.example.digikalaapp.ui.screens.SplashScreen
import com.example.digikalaapp.ui.screens.home.WebPageScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(route = Screen.Category.route) {
            CategoryScreen(navController)
        }

        composable(route = Screen.Basket.route) {
            BasketScreen(navController)
        }


        composable(route = Screen.WebView.route + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url= url )
            }
        }
    }


}

