package com.example.digikalaapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikalaapp.navigation.Screen
import com.example.digikalaapp.ui.theme.Purple200
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Purple200
                )
            }
        }

        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.White
                )
            }
        }
    }


}
